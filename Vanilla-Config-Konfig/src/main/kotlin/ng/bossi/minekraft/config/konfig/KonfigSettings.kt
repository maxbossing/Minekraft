package ng.bossi.minekraft.config.konfig

import ng.bossi.minekraft.annotation.MinekraftInternal
import java.nio.file.Path

@MinekraftInternal
data class ConfigSettings(
    val path: Path, val currentVersion: Int, val migration: Migration<*>
)