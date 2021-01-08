package com.ab.vaccine.feature.summary.di

import android.app.Application
import com.ab.vaccine.VaccineReportApplication

object SummaryInjector {

    fun initialize(applicationContext: Application) {
        val coreComponent = (applicationContext as? VaccineReportApplication)?.coreComponent
                ?: throw IllegalStateException("Provider not implemented: $applicationContext")

        val featureComponent = DaggerSummaryComponent
            .factory()
            .create(coreComponent)
        SummaryComponent.INSTANCE = featureComponent
    }
}
