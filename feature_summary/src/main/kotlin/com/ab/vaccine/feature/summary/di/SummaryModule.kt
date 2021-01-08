package com.ab.vaccine.feature.summary.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ab.vaccine.core.di.viewmodel.DaggerViewModelFactory
import com.ab.vaccine.core.di.viewmodel.DaggerViewModelKey
import com.ab.vaccine.feature.summary.presentation.details.SummaryDetailsViewModel
import com.ab.vaccine.feature.summary.presentation.list.SummaryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class SummaryModule {

    @Binds
    abstract fun bindViewModelFactory(factoryDagger: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DaggerViewModelKey(SummaryViewModel::class)
    abstract fun bindSummaryListViewModel(viewModel: SummaryViewModel): ViewModel

    @Binds
    @IntoMap
    @DaggerViewModelKey(SummaryDetailsViewModel::class)
    abstract fun bindSummaryDetailsViewModel(viewModel: SummaryDetailsViewModel): ViewModel
}
