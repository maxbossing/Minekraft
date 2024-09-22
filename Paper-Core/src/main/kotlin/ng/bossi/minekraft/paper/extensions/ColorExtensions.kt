@file:Suppress("unused")

package ng.bossi.minekraft.paper.extensions

import net.kyori.adventure.text.format.TextColor
import org.bukkit.Color as BukkitColor
import java.awt.Color as JavaColor

// FROM ADVENTURE TEXTCOLOR

val TextColor.bukkit
    get() = BukkitColor.fromRGB(value())

// FROM BUKKIT COLOR

val BukkitColor.adventure: TextColor
    get() = TextColor.color(asRGB())

val BukkitColor.awt: JavaColor
    get() = JavaColor(asRGB())

// FROM JAVA AWT COLOR

val JavaColor.bukkit
    get() = BukkitColor.fromRGB(rgb)

