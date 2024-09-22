plugins {
    kotlin("jvm")
}


dependencies {
    val version = Versions.ADVENTURE
    implementation("net.kyori", "adventure-api", version)
    implementation("net.kyori", "adventure-text-minimessage", version)
    implementation("net.kyori", "adventure-text-serializer-plain", version)
    implementation("net.kyori", "adventure-text-serializer-gson", version)
}