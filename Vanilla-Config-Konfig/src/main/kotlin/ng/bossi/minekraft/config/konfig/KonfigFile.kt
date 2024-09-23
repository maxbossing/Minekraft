package ng.bossi.minekraft.config.konfig

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import ng.bossi.minekraft.annotation.MinekraftInternal
import kotlin.reflect.KClass

@MinekraftInternal
data class ConfigFile<T : @Serializable Any>(
    val type: KClass<T>, val settings: ConfigSettings, val defaultInstance: T, val json: Json
)