package com.ab.vaccine.core.di

import android.content.Context
import com.ab.vaccine.core.di.module.CoreModule
import com.ab.vaccine.core.di.module.CoreNetworkModule
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import okhttp3.OkHttpClient

@Singleton
@Component(
        modules = [CoreModule::class, CoreNetworkModule::class]
)
interface CoreComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: CoreComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): CoreComponent
    }

    fun getGson(): Gson
    fun getOkhttp(): OkHttpClient
}
