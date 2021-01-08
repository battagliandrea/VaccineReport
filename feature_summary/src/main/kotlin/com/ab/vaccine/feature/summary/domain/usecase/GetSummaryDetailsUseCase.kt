package com.ab.vaccine.feature.summary.domain.usecase

import com.ab.vaccine.feature.summary.domain.repository.VaccineRepository
import javax.inject.Inject

internal class GetSummaryDetailsUseCase @Inject constructor(
    private val vaccineRepository: VaccineRepository
) {
    suspend operator fun invoke(area: String) =
        vaccineRepository.getVaccineAdministrationSummary(area)
}
