package com.ab.vaccine

import com.ab.vaccine.core.VaccineReportCoreApplication
import com.ab.vaccine.core.di.CoreComponent
import com.ab.vaccine.di.AppInjector

class VaccineReportApplication : VaccineReportCoreApplication() {

    override fun initializeAppComponent(coreComponent: CoreComponent) {
        AppInjector.initialize(this, coreComponent)
    }
}
