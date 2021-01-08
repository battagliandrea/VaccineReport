package com.ab.vaccine.feature.summary.di

import com.ab.vaccine.core.di.CoreComponent
import com.ab.vaccine.core.di.scope.FeatureScope
import com.ab.vaccine.feature.summary.presentation.details.SummaryDetailsFragment
import com.ab.vaccine.feature.summary.presentation.list.SummaryFragment
import dagger.Component

@FeatureScope
@Component(
        modules = [SummaryModule::class, SummaryDataModule::class],
        dependencies = [CoreComponent::class]
)
interface SummaryComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: SummaryComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): SummaryComponent
    }

    fun inject(fragment: SummaryFragment)
    fun inject(fragment: SummaryDetailsFragment)
}
