package ng.bossi.minekraft.extensions

import ng.bossi.minekraft.json
import java.nio.file.Path
import kotlin.io.path.createFile
import kotlin.io.path.createParentDirectories
import kotlin.io.path.exists
import kotlin.io.path.readText

inline fun <reified T : Any> Path.loadSerializable(): T? {
    return if (exists())
        try {
            json.decodeFromString<T>(readText())
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    else {
        createParentDirectories()
        createFile()
        return null
    }
}