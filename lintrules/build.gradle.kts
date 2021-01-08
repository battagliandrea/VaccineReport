plugins {
    id(GradlePluginId.JAVA_LIBRARY)
    id(GradlePluginId.KOTLIN)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(LibraryDependency.KOTLIN)
    compileOnly(LibraryDependency.ANDROID_LINT)
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Lint-Registry-v2"] = "com.battagliandrea.lintrules.MyIssueRegistry"
    }
}
