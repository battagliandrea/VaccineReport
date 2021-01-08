package com.ab.vaccine.feature.summary.data.model

import com.ab.vaccine.feature.summary.domain.model.SummaryDomainModel
import com.google.gson.annotations.SerializedName

internal data class SummaryDataModel(
    @SerializedName("index")
    val index: Int? = 0, // 0
    @SerializedName("area")
    val area: String? = "", // ABR
    @SerializedName("dosi_somministrate")
    val dosiSomministrate: Int? = 0, // 10835
    @SerializedName("dosi_consegnate")
    val dosiConsegnate: Int? = 0, // 15735
    @SerializedName("percentuale_somministrazione")
    val percentualeSomministrazione: Double? = 0.0, // 68.9
    @SerializedName("ultimo_aggiornamento")
    val ultimoAggiornamento: String? = "" // 2021-01-09T00:00:00.000Z
)

internal fun List<SummaryDataModel?>.toDomainModels(): List<SummaryDomainModel> =
    this.filterNotNull()
        .map { it.toDomainModel() }

internal fun SummaryDataModel.toDomainModel(): SummaryDomainModel =
    SummaryDomainModel(
        area = this.area.orEmpty(),
        administrationPercent = this.percentualeSomministrazione ?: 0.0,
        dateUpdate = this.ultimoAggiornamento.orEmpty()

    )
