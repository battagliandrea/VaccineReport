package com.ab.vaccine.feature.summary.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ab.vaccine.core.delegate.viewBinding
import com.ab.vaccine.core.presentation.extensions.observe
import com.ab.vaccine.feature.summary.R
import com.ab.vaccine.feature.summary.databinding.FragmentSummaryBinding
import com.ab.vaccine.feature.summary.di.SummaryComponent
import com.ab.vaccine.feature.summary.di.SummaryInjector
import javax.inject.Inject

class SummaryFragment @Inject constructor() : Fragment(R.layout.fragment_summary) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: SummaryViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SummaryInjector.initialize(
            applicationContext = requireActivity().application
        )
        SummaryComponent.INSTANCE.inject(this)
    }

    @Inject
    internal lateinit var summartAdapter: SummaryAdapter

    private val binding by viewBinding(FragmentSummaryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this, viewModelFactory)[SummaryViewModel::class.java]
        observe(mViewModel.stateLiveData, ::onStateChange)

        summartAdapter.setOnDebouncedClickListener { model ->
            val action = SummaryFragmentDirections.actionSummaryFragmentToSummaryDetailsFragment(area = model.area)
            findNavController().navigate(action)
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = summartAdapter
        }

        mViewModel.getData()
    }

    private fun onStateChange(state: SummaryViewModel.ViewState) {
        summartAdapter.summaryData = state.summaryData
    }
}
