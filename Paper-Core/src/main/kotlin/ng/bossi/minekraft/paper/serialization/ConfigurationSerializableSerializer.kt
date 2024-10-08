package ng.bossi.minekraft.paper.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.configuration.serialization.ConfigurationSerialization

/**
 * Serializer for [Any] that implements [ConfigurationSerializable]
 * @since 0.0.1
 * @author Junhyung Im (https://github.com/entrypointkr)
 */
object ConfigurationSerializableSerializer : KSerializer<ConfigurationSerializable> {
    private val mapSerializer: KSerializer<Map<String, Any?>> =
        MapSerializer(
            String.serializer(),
            ConfigAnySerializer
        )
    override val descriptor: SerialDescriptor
        get() = mapSerializer.descriptor

    override fun serialize(encoder: Encoder, value: ConfigurationSerializable) {
        val map = value.serialize()
        val alias = ConfigurationSerialization.getAlias(value.javaClass)
        return mapSerializer.serialize(
            encoder,
            map + (ConfigurationSerialization.SERIALIZED_TYPE_KEY to alias)
        )
    }

    override fun deserialize(decoder: Decoder): ConfigurationSerializable {
        val map = mapSerializer.deserialize(decoder)
        return ConfigurationSerialization.deserializeObject(map)
            ?: throw IllegalStateException(map.toString())
    }
}