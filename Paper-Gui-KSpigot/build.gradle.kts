plugins {
    kotlin
    adventure
    paper
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Vanilla"))
    implementation(project(":Paper-Core"))
}