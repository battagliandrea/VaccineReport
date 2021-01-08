package com.ab.vaccine.core.di.module

import android.content.Context
import android.content.SharedPreferences
import com.ab.vaccine.core.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

@Module
internal class SharedPreferencesModule(val context: Context, val name: String) {

    @Provides
    @FeatureScope
    fun provideSharedPreferences(): SharedPreferences {
        return context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)
    }
}
