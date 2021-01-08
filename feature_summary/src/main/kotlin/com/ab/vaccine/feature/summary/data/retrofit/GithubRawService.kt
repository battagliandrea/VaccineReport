package com.ab.vaccine.feature.summary.data.retrofit

import retrofit2.Response
import retrofit2.http.GET

internal interface GithubRawService {

    @GET("dati/vaccini-summary-latest.json")
    suspend fun getVaccineSummary(): Response<GetVaccineSummaryResponse>

    @GET("dati/somministrazioni-vaccini-latest.json")
    suspend fun getVaccineAdministrationSummary(): Response<GetVaccineAdministrationResponse>
}
