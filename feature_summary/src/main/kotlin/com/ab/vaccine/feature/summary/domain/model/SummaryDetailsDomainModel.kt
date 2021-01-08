package com.ab.vaccine.feature.summary.domain.model

internal data class SummaryDetailsDomainModel(
    val area: String,
    val registryRange: List<Series>,
    val categories: List<Series>
) {

    data class Series(
        val label: String,
        val value: Int
    )

    val registryRangeMax: Int by lazy {
        registryRange.maxByOrNull { it.value }?.value ?: 10000
    }

    companion object {
        val DEFAULT_INSTANCE = SummaryDetailsDomainModel(
                area = "",
                registryRange = listOf(),
                categories = listOf()
        )
    }
}
