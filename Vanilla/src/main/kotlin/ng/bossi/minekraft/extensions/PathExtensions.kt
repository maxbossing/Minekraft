package ng.bossi.minekraft.extensions

import ng.bossi.minekraft.json
import java.nio.file.Path
import kotlin.io.path.*

inline fun <reified T: Any> Path.loadSerializable() : T? {
    return if (exists())
        try {
            json.decodeFromString<T>(readText())
        } catch (e : Exception) {
            e.printStackTrace()
            return null
        }
    else{
        createParentDirectories()
        createFile()
        return null
    }
}