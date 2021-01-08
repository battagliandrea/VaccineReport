package com.ab.vaccine.feature.summary.domain.repository

import com.ab.vaccine.feature.summary.domain.model.SummaryDetailsDomainModel
import com.ab.vaccine.feature.summary.domain.model.SummaryDomainModel

internal interface VaccineRepository {

    suspend fun getVaccineSummary(): List<SummaryDomainModel>

    suspend fun getVaccineAdministrationSummary(area: String): SummaryDetailsDomainModel
}
