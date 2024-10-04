package ng.bossi.minekraft.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.kyori.adventure.text.Component
import ng.bossi.minekraft.miniMessage

object MiniMessageSerializer : KSerializer<Component> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MiniMessage", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Component = miniMessage.deserialize(decoder.decodeString())
    override fun serialize(encoder: Encoder, value: Component) = encoder.encodeString(miniMessage.serialize(value))
}