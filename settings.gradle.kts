pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.0"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include(":Vanilla")
include(":Vanilla-Config-Konfig")
include(":Paper-Core")
include(":Paper-Gui-KSpigot")
include(":Paper-Metrics-BStats")