package com.ab.vaccine.feature.splash.di

import com.ab.vaccine.core.di.CoreComponent
import com.ab.vaccine.core.di.scope.FeatureScope
import com.ab.vaccine.feature.splash.presentation.SplashFragment
import dagger.Component

@FeatureScope
@Component(
        modules = [SplashModule::class],
        dependencies = [CoreComponent::class]
)
interface SplashComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: SplashComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): SplashComponent
    }

    fun inject(fragment: SplashFragment)
}
