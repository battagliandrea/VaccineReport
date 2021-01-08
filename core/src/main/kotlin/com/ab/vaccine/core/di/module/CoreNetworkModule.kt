package com.ab.vaccine.core.di.module

import com.ab.vaccine.core.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
internal class CoreNetworkModule {

    // /////////////////////////////////
    //          OKHTTP
    // /////////////////////////////////
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }

    // /////////////////////////////////
    //          GSON
    // /////////////////////////////////
    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()
}
