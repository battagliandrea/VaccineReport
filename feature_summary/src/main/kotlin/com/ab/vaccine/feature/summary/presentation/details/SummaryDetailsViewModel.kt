package com.ab.vaccine.feature.summary.presentation.details

import androidx.lifecycle.viewModelScope
import com.ab.vaccine.core.presentation.viewmodel.BaseAction
import com.ab.vaccine.core.presentation.viewmodel.BaseViewModel
import com.ab.vaccine.core.presentation.viewmodel.BaseViewState
import com.ab.vaccine.feature.summary.domain.model.SummaryDetailsDomainModel
import com.ab.vaccine.feature.summary.domain.usecase.GetSummaryDetailsUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

internal class SummaryDetailsViewModel @Inject constructor(
    private val getSummaryDetailsUseCase: GetSummaryDetailsUseCase
) : BaseViewModel<SummaryDetailsViewModel.ViewState, SummaryDetailsViewModel.Action>(
    ViewState()
) {

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.DetailsLoading -> state.copy(
            area = viewAction.area,
            isLoading = true,
            isError = false,
            details = SummaryDetailsDomainModel.DEFAULT_INSTANCE
        )
        is Action.DetailsLoadingSuccess -> state.copy(
            area = viewAction.area,
            isLoading = false,
            isError = false,
            details = viewAction.details

        )
        is Action.DetailsLoadingFailure -> state.copy(
            isLoading = false,
            isError = false
        )
    }

    fun getData(area: String) {
        sendAction(Action.DetailsLoading(area = area))
        viewModelScope.launch {
            getSummaryDetailsUseCase(area).also {
                sendAction(Action.DetailsLoadingSuccess(area = it.area, details = it))
            }
        }
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val area: String = "",
        val details: SummaryDetailsDomainModel = SummaryDetailsDomainModel.DEFAULT_INSTANCE
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class DetailsLoading(val area: String) : Action()
        class DetailsLoadingSuccess(val area: String, val details: SummaryDetailsDomainModel) : Action()
        object DetailsLoadingFailure : Action()
    }
}
