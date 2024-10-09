plugins {
    kotlin
    serialization
    dokka
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Vanilla"))
}