package com.ab.vaccine.feature.summary.presentation.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ab.vaccine.core.delegate.observer
import com.ab.vaccine.feature.summary.databinding.FragmentDetailsSummaryStatListItemBinding
import com.ab.vaccine.feature.summary.domain.model.SummaryDetailsDomainModel
import javax.inject.Inject

internal class RegistryRangeAdapter @Inject constructor() : RecyclerView.Adapter<RegistryRangeAdapter.ViewHolder>() {

    var max: Int = 100

    var data: List<SummaryDetailsDomainModel.Series> by observer(listOf()) {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = FragmentDetailsSummaryStatListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], max)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        private val itemBinding: FragmentDetailsSummaryStatListItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(domainModel: SummaryDetailsDomainModel.Series, max: Int) {
            itemBinding.tvName.text = domainModel.label
            itemBinding.tvValue.text = "${domainModel.value}"
            itemBinding.progressBar.max = max
            itemBinding.progressBar.progress = domainModel.value
        }
    }
}
