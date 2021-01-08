package com.ab.vaccine.feature.summary.di

import com.ab.vaccine.core.BuildConfig
import com.ab.vaccine.core.di.scope.FeatureScope
import com.ab.vaccine.feature.summary.data.repository.VaccineRepositoryImpl
import com.ab.vaccine.feature.summary.data.retrofit.GithubRawService
import com.ab.vaccine.feature.summary.domain.repository.VaccineRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
internal class SummaryDataModule {

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //          REPOSITORY
    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Provides
    @FeatureScope
    fun provideSummaryRepository(sr: VaccineRepositoryImpl): VaccineRepository = sr

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //          RETROFIT DATASOURCE
    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Provides
    @FeatureScope
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): GithubRawService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GithubRawService::class.java)
    }
}
