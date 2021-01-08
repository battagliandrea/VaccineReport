package com.ab.vaccine.feature.summary.presentation.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ab.vaccine.core.delegate.viewBinding
import com.ab.vaccine.core.extensions.getStringResourceByName
import com.ab.vaccine.core.presentation.extensions.observe
import com.ab.vaccine.feature.summary.R
import com.ab.vaccine.feature.summary.databinding.FragmentDetailsSummaryBinding
import com.ab.vaccine.feature.summary.di.SummaryComponent
import com.ab.vaccine.feature.summary.di.SummaryInjector
import javax.inject.Inject

class SummaryDetailsFragment @Inject constructor() : Fragment(R.layout.fragment_details_summary) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: SummaryDetailsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SummaryInjector.initialize(
            applicationContext = requireActivity().application
        )
        SummaryComponent.INSTANCE.inject(this)
    }

    @Inject
    internal lateinit var registryRangeAdapter: RegistryRangeAdapter

    @Inject
    internal lateinit var categoryAdapter: CategoryAdapter

    val args: SummaryDetailsFragmentArgs by navArgs()

    private val binding by viewBinding(FragmentDetailsSummaryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this, viewModelFactory)[SummaryDetailsViewModel::class.java]
        observe(mViewModel.stateLiveData, ::onStateChange)

        binding.rvRegistryRange.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = registryRangeAdapter
        }

        binding.rvCategory.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        mViewModel.getData(args.area)
    }

    private fun onStateChange(state: SummaryDetailsViewModel.ViewState) {

        binding.tvTitle.text = state.area.getStringResourceByName(context)
        binding.tvRegistryRangeTitle.visibility = if (state.isLoading) View.INVISIBLE else View.VISIBLE
        binding.tvCategoryTitle.visibility = if (state.isLoading) View.INVISIBLE else View.VISIBLE

        registryRangeAdapter.apply {
            max = state.details.registryRangeMax
            data = state.details.registryRange
        }
        categoryAdapter.data = state.details.categories
    }
}
