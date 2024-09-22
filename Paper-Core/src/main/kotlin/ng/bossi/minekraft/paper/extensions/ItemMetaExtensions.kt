package ng.bossi.minekraft.paper.extensions

import com.destroystokyo.paper.profile.ProfileProperty
import ng.bossi.minekraft.text.legacy
import org.bukkit.Bukkit
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.inventory.meta.SkullMeta
import java.util.*

fun BookMeta.content() = StringBuilder().apply {
    for (it in pages().map { it.legacy() }) {
        if (isNotEmpty())
            append('\n')
        append(it)
    }
}.toString()


fun SkullMeta.skullTexture(base64: String, uuid: UUID = UUID.randomUUID()): SkullMeta {
    val profile = Bukkit.createProfile(uuid)
    profile.setProperty(ProfileProperty("textures", base64))
    playerProfile = profile
    return this
}