pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:3.5.1")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.4.10")
            }
        }
    }
}

rootProject.name = "VaccineReport"
rootProject.buildFileName = "build.gradle.kts"
rootDir
    .walk()
    .maxDepth(1)
    .filter {
        it.name != "buildSrc" &&
            it.isDirectory &&
            file("${it.absolutePath}/build.gradle.kts").exists()
    }
    .forEach {
        include(":${it.name}")
    }
