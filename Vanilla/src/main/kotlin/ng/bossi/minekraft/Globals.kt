package ng.bossi.minekraft

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import net.kyori.adventure.text.minimessage.MiniMessage

@OptIn(ExperimentalSerializationApi::class)
val json by lazy {
    Json {
        prettyPrint = true
        encodeDefaults = true
        isLenient = true
        classDiscriminator = "type"
        prettyPrintIndent = "  "
        ignoreUnknownKeys = true
    }
}

var miniMessage = MiniMessage.miniMessage()