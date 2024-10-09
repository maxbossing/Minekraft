plugins {
    id("org.jetbrains.dokka")
}

repositories {
    mavenCentral()
}

tasks {
    withType<org.jetbrains.dokka.gradle.DokkaTaskPartial> {
        enabled = false
    }
}
