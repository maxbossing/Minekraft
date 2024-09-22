plugins {
    kotlin("jvm")
    id("io.papermc.paperweight.userdev")
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("${Versions.MINECRAFT}-R0.1-SNAPSHOT")
}