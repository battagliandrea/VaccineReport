package com.ab.vaccine.core

import android.app.Application
import com.ab.vaccine.core.di.CoreComponent
import com.ab.vaccine.core.di.CoreInjector

abstract class VaccineReportCoreApplication : Application() {

    val coreComponent: CoreComponent
        get() = CoreComponent.INSTANCE

    override fun onCreate() {
        super.onCreate()
        val coreComponent = initializeCoreComponent()
        initializeAppComponent(coreComponent)
    }

    protected abstract fun initializeAppComponent(coreComponent: CoreComponent)

    private fun initializeCoreComponent(): CoreComponent {
        CoreInjector.initialize(this)
        return coreComponent
    }
}
