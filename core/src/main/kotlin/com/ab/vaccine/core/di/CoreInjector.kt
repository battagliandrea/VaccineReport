package com.ab.vaccine.core.di

import android.app.Application

object CoreInjector {

    fun initialize(application: Application) {
        val coreComponent = DaggerCoreComponent.factory().create(application)
        CoreComponent.INSTANCE = coreComponent
    }
}
