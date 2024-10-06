@file:OptIn(MinekraftInternal::class)
package ng.bossi.minekraft.config.konfig

import ng.bossi.minekraft.annotation.MinekraftInternal
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import java.nio.file.Path
import kotlin.io.path.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.io.path.createDirectories
import kotlin.io.path.createFile
import kotlin.io.path.exists
import kotlin.io.path.readText
import kotlin.io.path.writeText

@MinekraftInternal
var konfigFiles: MutableList<ConfigFile<*>> = mutableListOf()

@MinekraftInternal
@Suppress("SpellCheckingInspection")
@Serializable
data class Konfig<T>(val version: Int, val config: @Serializable T)


inline fun <reified T : @Serializable Any> konfig(
    path: Path,
    currentVersion: Int,
    defaultConfig: T,
    noinline migration: Migration<T>
) {
    konfigFiles.add(ConfigFile(T::class, ConfigSettings(path, currentVersion, migration), defaultConfig))
}

@Suppress("unused", "unchecked_cast")
inline fun <reified T : @Serializable Any> loadConfig(): @Serializable T {
    val configFile = konfigFiles.find { it.type == T::class } as? ConfigFile<T>
    if (configFile == null) throw IllegalArgumentException("No config for class ${T::class.simpleName} found!")

    val defaultInstance = configFile.defaultInstance
    val path = configFile.settings.path

    if (path.configInstantiated(defaultInstance)) return defaultInstance

    val text = path.readText()
    return try {
        json.decodeFromString<Konfig<T>>(text).config
    } catch (e: Throwable) {
        handleException(text, configFile)
    }
}

@Suppress("unchecked_cast")
inline fun <reified T : @Serializable Any> saveConfig(config: @Serializable T) {
    val file = konfigFiles.find { it.type == T::class } as? ConfigFile<T>
    if (file == null) throw IllegalArgumentException("No config for class ${T::class.simpleName} found!")
    val path = file.settings.path

    path.writeText(json.encodeToString(Konfig(file.settings.currentVersion, config)))
}

@MinekraftInternal
inline fun <reified T : @Serializable Any> Path.configInstantiated(defaultInstance: T): Boolean {
    if (exists()) return false
    parent.createDirectories()
    createFile()

    saveConfig<T>(defaultInstance)
    return true
}

@MinekraftInternal
inline fun <reified T : @Serializable Any> handleException(
    fileText: String, configFile: ConfigFile<T>
): @Serializable T {
    val jsonTree = runCatching { json.parseToJsonElement(fileText) }.getOrNull() ?: return resetConfig(configFile)
    val version = jsonTree.jsonObject["version"]?.jsonPrimitive?.intOrNull
    if (version == configFile.settings.currentVersion) return resetConfig(configFile)

    val config = configFile.settings.migration.invoke(
        if (version == null) {
            jsonTree
        } else {
            jsonTree.jsonObject["config"] ?: jsonTree
        }, version
    ) as? T
    saveConfig(config ?: configFile.defaultInstance)
    return config ?: configFile.defaultInstance
}

@MinekraftInternal
inline fun <reified T : @Serializable Any> resetConfig(configFile: ConfigFile<T>): T {
    saveConfig(configFile.defaultInstance)
    return configFile.defaultInstance
}