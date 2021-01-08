package com.ab.vaccine.feature.splash.di

import android.app.Application
import com.ab.vaccine.VaccineReportApplication

object SplashInjector {

    fun initialize(applicationContext: Application) {
        val coreComponent = (applicationContext as? VaccineReportApplication)?.coreComponent
                ?: throw IllegalStateException("Provider not implemented: $applicationContext")

        val featureComponent = DaggerSplashComponent
            .factory()
            .create(coreComponent)
        SplashComponent.INSTANCE = featureComponent
    }
}
