import org.jetbrains.dokka.gradle.DokkaTaskPartial
import java.net.URI

plugins {
    id("org.jetbrains.dokka")
}

repositories {
    mavenCentral()
}

tasks {
    val processDokkaMarkdown = register<Copy>("processDokkaMarkdown") {
        from(layout.projectDirectory.dir("docs"))
        into(layout.buildDirectory.dir("docs-markdown"))
    }

    withType<DokkaTaskPartial> {
        dependsOn(processDokkaMarkdown)

        dokkaSourceSets {
            configureEach {
                includes.from(
                    layout.buildDirectory.get().asFile.resolve("docs-markdown").listFiles()!!
                        .sortedBy { if (it.name == "Module.md") "0" else it.name }
                        .map { "build/docs-markdown/${it.name}" }
                        .toTypedArray()
                )

                sourceLink {
                    localDirectory.set(file("src/main/kotlin"))
                    remoteUrl.set(URI.create("https://github.com/${Constants.GITHUB}/tree/main/${project.name}/src/main/kotlin").toURL())
                    remoteLineSuffix.set("#L")
                }

                listOf("internal", "mixin").forEach {
                    perPackageOption {
                        matchingRegex.set(""".*\.$it.*""")
                        suppress.set(true)
                    }
                }
            }
        }
    }
}