package com.ab.vaccine.feature.summary.data.retrofit

import com.ab.vaccine.feature.summary.data.model.SummaryAdministrationDataModel
import com.google.gson.annotations.SerializedName

internal data class GetVaccineAdministrationResponse(
    @SerializedName("data")
    val `data`: List<SummaryAdministrationDataModel?>? = listOf()
)
