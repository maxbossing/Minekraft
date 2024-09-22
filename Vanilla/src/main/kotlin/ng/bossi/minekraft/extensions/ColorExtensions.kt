package ng.bossi.minekraft.extensions

import net.kyori.adventure.text.format.TextColor
import java.awt.Color
import java.awt.Color as JavaColor

val TextColor.awt: JavaColor
    get() = Color(value())

val JavaColor.adventure: TextColor
    get() = TextColor.color(rgb)