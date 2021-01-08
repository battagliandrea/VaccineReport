package com.ab.vaccine.feature.summary.presentation.list

import androidx.lifecycle.viewModelScope
import com.ab.vaccine.core.presentation.viewmodel.BaseAction
import com.ab.vaccine.core.presentation.viewmodel.BaseViewModel
import com.ab.vaccine.core.presentation.viewmodel.BaseViewState
import com.ab.vaccine.feature.summary.domain.model.SummaryDomainModel
import com.ab.vaccine.feature.summary.domain.usecase.GetSummaryListUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

internal class SummaryViewModel @Inject constructor(
    private val getSummaryListUseCase: GetSummaryListUseCase
) : BaseViewModel<SummaryViewModel.ViewState, SummaryViewModel.Action>(
    ViewState()
) {

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.SummaryListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            summaryData = viewAction.summaryData
        )
        is Action.SummaryListLoadingFailure -> state.copy(
            isLoading = false,
            isError = false,
            summaryData = listOf()
        )
    }

    fun getData() {
        viewModelScope.launch {
            getSummaryListUseCase().also {
                if (it.isNotEmpty()) {
                    sendAction(
                        Action.SummaryListLoadingSuccess(
                            it
                        )
                    )
                } else {
                    sendAction(Action.SummaryListLoadingFailure)
                }
            }
        }
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val summaryData: List<SummaryDomainModel> = listOf()
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class SummaryListLoadingSuccess(val summaryData: List<SummaryDomainModel>) : Action()
        object SummaryListLoadingFailure : Action()
    }
}
