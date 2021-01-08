private object CoreVersion {
    const val KOTLIN = "1.4.21"
    const val COROUTINES_ANDROID = "1.3.7"
    const val KTLINT = "0.34.2"
}

private object Version {

    const val ANDROID_LINT = "26.5.3"

    const val CORE_KTX = "1.2.0"
    const val FRAGMENT_KTX = "1.2.4"
    const val APP_COMPAT = "1.1.0"
    const val LIFECYCLE = "2.2.0"
    const val RECYCLER_VIEW = "1.1.0"
    const val COORDINATOR_LAYOUT = "1.1.0"
    const val MATERIAL = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"

    const val NAVIGATION = "2.3.1"

    const val DAGGER = "2.30.1"
    const val RETROFIT = "2.8.2"
    const val OK_HTTP = "4.7.2"
    const val GLIDE = "4.11.0"

    const val GSON = "2.8.5"
}

object GradlePluginVersion {
    const val KTLINT_GRADLE = "9.4.1"
    const val KTLINT = CoreVersion.KTLINT
    const val KOTLIN = CoreVersion.KOTLIN
    const val SAFE_ARGS = Version.NAVIGATION
}


object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"
    const val JAVA_LIBRARY = "java-library"
    const val KOTLIN = "kotlin"
    const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val KOTLIN_KAPT = "org.jetbrains.kotlin.kapt"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KTLINT_GRADLE = "org.jlleitschuh.gradle.ktlint"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
}

object LibraryDependency {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersion.KOTLIN}"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${CoreVersion.KOTLIN}"

    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersion.COROUTINES_ANDROID}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersion.COROUTINES_ANDROID}"

    const val ANDROID_LINT = "com.android.tools.lint:lint-api:${Version.ANDROID_LINT}"

    const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Version.FRAGMENT_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"
    const val LIFECYCLE_EXTENSIONS = "android.arch.lifecycle:extensions:${Version.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Version.LIFECYCLE}"
    const val LIFECYCLE_JAVA_8 = "androidx.lifecycle:lifecycle-common-java8:${Version.LIFECYCLE}"
    const val LIFECYCLE_VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE}"
    const val LIFECYCLE_VIEW_MODEL_SAVED_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.LIFECYCLE}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Version.RECYCLER_VIEW}"
    const val COORDINATOR_LAYOUT = "androidx.coordinatorlayout:coordinatorlayout:${Version.COORDINATOR_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"

    const val NAVIGATION_FRAGMENT_KTX =  "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"
    const val NAVIGATION_UI_KTX =  "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"
    const val NAVIGATION_FEATURES =  "androidx.navigation:navigation-dynamic-features-fragment:${Version.NAVIGATION}"

    const val DAGGER = "com.google.dagger:dagger:${Version.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Version.DAGGER}"
    const val DAGGER_PROCESSOR = "com.google.dagger:dagger-android-processor:${Version.DAGGER}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"
    const val RETROFIT_MOCK = "com.squareup.retrofit2:retrofit-mock:${Version.RETROFIT}"

    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Version.OK_HTTP}"
    const val OK_HTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Version.OK_HTTP}"
    const val OK_HTTP_MOCK = "com.squareup.okhttp3:mockwebserver:${Version.OK_HTTP}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Version.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Version.GLIDE}"

    const val GSON = "com.google.code.gson:gson:${Version.GSON}"
}