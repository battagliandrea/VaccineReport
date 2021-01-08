package com.ab.vaccine.di

import android.app.Application
import com.ab.vaccine.core.di.CoreComponent

object AppInjector {

    fun initialize(application: Application, coreComponent: CoreComponent) {
        AppComponent.INSTANCE = DaggerAppComponent.factory().create(application, coreComponent)
    }
}
