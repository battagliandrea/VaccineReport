import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id(GradlePluginId.KTLINT_GRADLE) version GradlePluginVersion.KTLINT_GRADLE

    id(GradlePluginId.KOTLIN_JVM) version GradlePluginVersion.KOTLIN apply false
    id(GradlePluginId.KOTLIN_ANDROID) version GradlePluginVersion.KOTLIN apply false
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS) version GradlePluginVersion.KOTLIN apply false
    id(GradlePluginId.ANDROID_APPLICATION) version GradlePluginVersion.ANDROID_GRADLE apply false
    id(GradlePluginId.ANDROID_DYNAMIC_FEATURE) version GradlePluginVersion.ANDROID_GRADLE apply false
    id(GradlePluginId.ANDROID_LIBRARY) version GradlePluginVersion.ANDROID_GRADLE apply false
//    id(GradlePluginId.SAFE_ARGS) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

subprojects {
    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }

    afterEvaluate {
        configureAndroid()
    }

    apply(plugin = GradlePluginId.KTLINT_GRADLE)

    ktlint {
        version.set(GradlePluginVersion.KTLINT)
        verbose.set(true)
        android.set(true)
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
        disabledRules.set(setOf("max-line-length"))

        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

fun Project.configureAndroid() {
    (project.extensions.findByName("android") as? com.android.build.gradle.BaseExtension)?.run {
        sourceSets {
            map { it.java.srcDir("src/${it.name}/kotlin") }
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
buildscript {
    val kotlin_version by extra("1.3.72")
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}
