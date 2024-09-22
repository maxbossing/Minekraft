@file:Suppress("unused")

package ng.bossi.minekraft.paper.serialization.impl

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import ng.bossi.minekraft.paper.serialization.ConfigurationSerializableSerializer
import org.bukkit.Location

typealias SerializableLocation = @Serializable(LocationSerializer::class) Location

object LocationSerializer : KSerializer<Location> {
    override val descriptor: SerialDescriptor
        get() = ConfigurationSerializableSerializer.descriptor

    override fun deserialize(decoder: Decoder): Location {
        val serializable = decoder.decodeSerializableValue(ConfigurationSerializableSerializer)
        return serializable as Location
    }

    override fun serialize(encoder: Encoder, value: Location) =
        encoder.encodeSerializableValue(ConfigurationSerializableSerializer, value)
}