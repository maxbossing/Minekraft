package ng.bossi.minekraft.config.konfig

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

typealias Migration<T> = (jsonTree: JsonElement, version: Int?) -> @Serializable T?