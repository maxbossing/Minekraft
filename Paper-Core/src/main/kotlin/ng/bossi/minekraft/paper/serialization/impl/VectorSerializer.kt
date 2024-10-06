@file:Suppress("unused")

package ng.bossi.minekraft.paper.serialization.impl

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import ng.bossi.minekraft.paper.serialization.ConfigurationSerializableSerializer
import org.bukkit.util.Vector

/**
 * Alias for [Vector]s using the [VectorSerializer]
 */
typealias VectorSerializable = @Serializable(VectorSerializer::class) Vector

/**
 * Serializer for [Vector]s using [ConfigurationSerializableSerializer]
 * @since 0.0.1
 * @author Junhyung Im (https://github.com/entrypointkr)
 */
object VectorSerializer : KSerializer<Vector> {
    override val descriptor: SerialDescriptor
        get() = ConfigurationSerializableSerializer.descriptor

    override fun serialize(encoder: Encoder, value: Vector) =
        encoder.encodeSerializableValue(ConfigurationSerializableSerializer, value)

    override fun deserialize(decoder: Decoder): Vector {
        val serializable = decoder.decodeSerializableValue(ConfigurationSerializableSerializer)
        return serializable as Vector
    }
}