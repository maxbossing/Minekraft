plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://repo.papermc.io/repository/maven-public/")
}


dependencies {
    // Kotlin
    implementation(kotlin("gradle-plugin", "2.0.20"))
    implementation("org.jetbrains.kotlin", "kotlin-serialization", "2.0.20")
    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.7.3")

    // Dokka
    implementation("org.jetbrains.dokka", "dokka-gradle-plugin", "2.0.0-Beta")
    implementation("org.jetbrains.dokka", "dokka-base", "2.0.0-Beta")

    //Paper
    implementation("io.papermc.paperweight.userdev", "io.papermc.paperweight.userdev.gradle.plugin", "1.7.2")
}