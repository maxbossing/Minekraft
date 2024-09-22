@file:Suppress("unused")

package ng.bossi.minekraft.paper.serialization.impl

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import ng.bossi.minekraft.paper.serialization.ConfigurationSerializableSerializer
import org.bukkit.inventory.ItemStack

typealias SerializableItemStack = @Serializable(ItemStackSerializer::class) ItemStack

object ItemStackSerializer : KSerializer<ItemStack> {
    override val descriptor: SerialDescriptor
        get() = ConfigurationSerializableSerializer.descriptor

    override fun serialize(encoder: Encoder, value: ItemStack) =
        encoder.encodeSerializableValue(ConfigurationSerializableSerializer, value)

    override fun deserialize(decoder: Decoder): ItemStack {
        val serializable = decoder.decodeSerializableValue(ConfigurationSerializableSerializer)
        return serializable as ItemStack
    }
}