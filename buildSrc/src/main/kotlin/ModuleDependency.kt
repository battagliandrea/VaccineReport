import kotlin.reflect.full.memberProperties

private const val FEATURE_PREFIX = ":feature_"

@Suppress("unused")
object ModuleDependency {

    const val APP = ":app"
    const val CORE = ":core"
    const val LINT_RULES = ":lintrules"

    const val FEATURE_SPLASH = ":feature_splash"

    fun getDynamicFeatureModules() =
        ModuleDependency::class.memberProperties
            .asSequence()
            .filter { it.isConst }
            .map { it.getter.call().toString() }
            .filter { it.startsWith(FEATURE_PREFIX) }
            .toSet()
}