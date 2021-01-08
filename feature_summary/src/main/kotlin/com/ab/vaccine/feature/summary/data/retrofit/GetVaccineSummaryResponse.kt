package com.ab.vaccine.feature.summary.data.retrofit

import com.ab.vaccine.feature.summary.data.model.SummaryDataModel
import com.google.gson.annotations.SerializedName

internal data class GetVaccineSummaryResponse(

    @SerializedName("data")
    val `data`: List<SummaryDataModel?>? = listOf()
)
