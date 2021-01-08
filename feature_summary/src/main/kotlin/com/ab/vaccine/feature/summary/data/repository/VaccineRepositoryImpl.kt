package com.ab.vaccine.feature.summary.data.repository

import com.ab.vaccine.feature.summary.data.model.toDomainModels
import com.ab.vaccine.feature.summary.data.retrofit.GithubRawService
import com.ab.vaccine.feature.summary.domain.model.SummaryDetailsDomainModel
import com.ab.vaccine.feature.summary.domain.model.SummaryDomainModel
import com.ab.vaccine.feature.summary.domain.repository.VaccineRepository
import javax.inject.Inject

internal class VaccineRepositoryImpl @Inject constructor(
    private val githubRawService: GithubRawService
) : VaccineRepository {

    override suspend fun getVaccineSummary(): List<SummaryDomainModel> {
        val response = githubRawService.getVaccineSummary()
        return if (response.isSuccessful) {
            response.body()?.data?.toDomainModels().orEmpty() // TODO: handle error
        } else {
            // TODO: handle error
            emptyList()
        }
    }

    override suspend fun getVaccineAdministrationSummary(area: String): SummaryDetailsDomainModel {
        val response = githubRawService.getVaccineAdministrationSummary()

        return if (response.isSuccessful) {
            response.body()?.data
                ?.filter { it?.area == area }
                ?.toDomainModels()!!
            // TODO: handle error
        } else {
            // TODO: handle error
            throw RuntimeException("getVaccineAdministrationSummary error")
        }
    }
}
