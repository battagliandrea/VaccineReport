package com.ab.vaccine.feature.summary.data.model

import com.ab.vaccine.feature.summary.domain.model.SummaryDetailsDomainModel
import com.google.gson.annotations.SerializedName

internal data class SummaryAdministrationDataModel(
    @SerializedName("index")
    val index: Int? = 0, // 0
    @SerializedName("data_somministrazione")
    val dataSomministrazione: String? = "", // 2020-12-27T00:00:00.000Z
    @SerializedName("area")
    val area: String? = "", // ABR
    @SerializedName("fascia_anagrafica")
    val fasciaAnagrafica: String? = "", // 16-19
    @SerializedName("sesso_maschile")
    val sessoMaschile: Int? = 0, // 0
    @SerializedName("sesso_femminile")
    val sessoFemminile: Int? = 0, // 0
    @SerializedName("categoria_operatori_sanitari_sociosanitari")
    val categoriaOperatoriSanitariSociosanitari: Int? = 0, // 0
    @SerializedName("categoria_personale_non_sanitario")
    val categoriaPersonaleNonSanitario: Int? = 0, // 0
    @SerializedName("categoria_ospiti_rsa")
    val categoriaOspitiRsa: Int? = 0 // 0
)

internal fun List<SummaryAdministrationDataModel?>.toDomainModels(): SummaryDetailsDomainModel {

    val registryRange: List<SummaryDetailsDomainModel.Series> = listOf(
            SummaryDetailsDomainModel.Series(
                    label = "16-19",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "16-19" })),
            SummaryDetailsDomainModel.Series(
                    label = "20-29",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "20-29" })),
            SummaryDetailsDomainModel.Series(
                    label = "30-39",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "30-39" })),
            SummaryDetailsDomainModel.Series(
                    label = "40-49",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "40-49" })),
            SummaryDetailsDomainModel.Series(
                    label = "50-59",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "50-59" })),
            SummaryDetailsDomainModel.Series(
                    label = "60-69",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "60-69" })),
            SummaryDetailsDomainModel.Series(
                    label = "70-79",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "70-79" })),
            SummaryDetailsDomainModel.Series(
                    label = "80-89",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "80-89" })),
            SummaryDetailsDomainModel.Series(
                    label = "90+",
                    value = maleFemaleSum(this.filter { it?.fasciaAnagrafica == "90+" }))
    )

    val categories: List<SummaryDetailsDomainModel.Series> = listOf(
        SummaryDetailsDomainModel.Series(
            label = "feature_summary_category_rsa",
            value = this.sumBy { it?.categoriaOspitiRsa ?: 0 }),
        SummaryDetailsDomainModel.Series(
            label = "feature_summary_category_health_worker",
            value = this.sumBy { it?.categoriaOperatoriSanitariSociosanitari ?: 0 }),
        SummaryDetailsDomainModel.Series(
            label = "feature_summary_category_other",
            value = this.sumBy { it?.categoriaPersonaleNonSanitario ?: 0 })
    )

    return SummaryDetailsDomainModel(
        area = this.first()?.area.orEmpty(),
        registryRange = registryRange,
        categories = categories
    )
}

private fun maleFemaleSum(list: List<SummaryAdministrationDataModel?>): Int {
    val sumMale = list.sumBy { model -> model?.sessoMaschile ?: 0 }
    val sumFemale = list.sumBy { model -> model?.sessoMaschile ?: 0 }
    return sumMale.plus(sumFemale)
}
