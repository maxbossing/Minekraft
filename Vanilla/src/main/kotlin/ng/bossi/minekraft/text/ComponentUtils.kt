@file:Suppress("unused")

package ng.bossi.minekraft.text

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextReplacementConfig
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.format.TextDecoration.State
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer

// If multiple colors, will be deserialized as a gradient from minimessage
fun text(
    str: String,
    vararg color: TextColor = arrayOf(Kolors.GRAY),
    bold: Boolean = false,
    italic: Boolean = false,
    underlined: Boolean = false,
    strikethrough: Boolean = false,
    obfuscated: Boolean = false,
): Component =
    (if (color.size == 1) Component.text(str).color(color.first()) else "<gradient:${color.joinToString(":") { it.asHexString() }}>$str</gradient>".miniMessage())
        .apply {
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

fun Component.hover(hover: Component) = hoverEvent(asHoverEvent().value(hover))
fun Component.url(url: String) = clickEvent(ClickEvent.openUrl(url))
fun Component.command(command: String) = clickEvent(ClickEvent.runCommand(command))
fun Component.suggest(suggestion: String) = clickEvent(ClickEvent.suggestCommand(suggestion))
fun Component.copy(copy: String) = clickEvent(ClickEvent.copyToClipboard(copy))
fun Component.callback(callback: (Audience) -> Unit) = clickEvent(ClickEvent.callback(callback))

fun String.component() = Component.text(this)
fun String.miniMessage() = ng.bossi.minekraft.miniMessage.deserialize(this)

fun Component.legacy() = LegacyComponentSerializer.legacy('§').serialize(this)
fun Component.plain() = PlainTextComponentSerializer.plainText().serialize(this)