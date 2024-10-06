@file:Suppress("unused")

package ng.bossi.minekraft.paper.serialization.impl

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import ng.bossi.minekraft.paper.serialization.ConfigurationSerializableSerializer
import org.bukkit.inventory.ItemStack

/**
 * Alias for [ItemStack]s using the [ItemStackSerializer]
 */
typealias SerializableItemStack = @Serializable(ItemStackSerializer::class) ItemStack

/**
 * Serializer for [ItemStack]s using [ConfigurationSerializableSerializer]
 * @since 0.0.1
 * @author Junhyung Im (https://github.com/entrypointkr)
 */
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