package com.ab.vaccine.di

import android.content.Context
import com.ab.vaccine.core.di.CoreComponent
import com.ab.vaccine.core.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
        modules = [],
        dependencies = [
            CoreComponent::class
        ]
)
interface AppComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: AppComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            coreComponent: CoreComponent
        ): AppComponent
    }
}
