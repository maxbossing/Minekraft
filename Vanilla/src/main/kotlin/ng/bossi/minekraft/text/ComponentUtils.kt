@file:Suppress("unused")

package ng.bossi.minekraft.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.format.TextDecoration.State

fun text(
    str: String,
    color: TextColor? = null,
    bold: Boolean = false,
    italic: Boolean = false,
    underlined: Boolean = false,
    strikethrough: Boolean = false,
    obfuscated: Boolean = false,
): Component = Component.text(str)
    .apply {
        color(color)
        decorations(
            mapOf(
                TextDecoration.BOLD to State.byBoolean(bold),
                TextDecoration.ITALIC to State.byBoolean(italic),
                TextDecoration.UNDERLINED to State.byBoolean(underlined),
                TextDecoration.STRIKETHROUGH to State.byBoolean(strikethrough),
                TextDecoration.OBFUSCATED to State.byBoolean(obfuscated),
            )
        )
    }

operator fun Component.plus(component: Component) = append(component)

fun Component.replace(old: String, new: Component) = this
    .replaceText(
        TextReplacementConfig
            .builder()
            .match(old)
            .replacement(new)
            .build()
    )
