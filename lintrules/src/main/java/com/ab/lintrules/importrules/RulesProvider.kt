package com.ab.lintrules.importrules

object RulesProvider {
    var rulesList: List<InvalidImportRule> = listOf(
        InvalidDomainToPresentationDependencyRule(),
        InvalidDomainToDataDependencyRule(),
        InvalidFeatureImportRule()
    )
}
