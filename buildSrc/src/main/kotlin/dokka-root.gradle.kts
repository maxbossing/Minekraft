import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask

plugins {
    id("org.jetbrains.dokka")
}

repositories {
    mavenCentral()
}

tasks {
    withType<DokkaMultiModuleTask> {
        includes.from("dokka/includes/index.md")

        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            customStyleSheets = listOf(*(rootDir.resolve("dokka/stylesheets").listFiles() ?: emptyArray()))
        }
    }
}