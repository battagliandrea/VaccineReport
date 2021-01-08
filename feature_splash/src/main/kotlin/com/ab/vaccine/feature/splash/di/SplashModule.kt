package com.ab.vaccine.feature.splash.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ab.vaccine.core.di.viewmodel.DaggerViewModelFactory
import com.ab.vaccine.core.di.viewmodel.DaggerViewModelKey
import com.ab.vaccine.feature.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class SplashModule {

    @Binds
    abstract fun bindViewModelFactory(factoryDagger: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DaggerViewModelKey(SplashViewModel::class)
    abstract fun bindCharacterListViewModel(viewModel: SplashViewModel): ViewModel
}
