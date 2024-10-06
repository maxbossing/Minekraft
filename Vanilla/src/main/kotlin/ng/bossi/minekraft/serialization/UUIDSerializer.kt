@file:Suppress("unused")

package ng.bossi.minekraft.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

/**
 * Alias type for [UUID]s serialized with [UUIDSerializer]
 * @since 0.0.1
 */
typealias SerializableUUID = @Serializable(UUIDSerializer::class) UUID

/**
 * A [KSerializer] for [UUID]s
 * @author Paul Kindler (https://github.com/kxmpxtxnt)
 * @since 0.0.1
 */
object UUIDSerializer : KSerializer<UUID> {
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    private const val UUID_PATTERN = "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})"

    override fun deserialize(decoder: Decoder): UUID {
        var uuid = decoder.decodeString()
        if (uuid.contains("-")) {
            uuid = uuid.replace(UUID_PATTERN, "$1-$2-$3-$4-$5")
        }
        return UUID.fromString(uuid)
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}