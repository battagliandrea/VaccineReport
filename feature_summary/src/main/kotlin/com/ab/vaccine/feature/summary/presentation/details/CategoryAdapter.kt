package com.ab.vaccine.feature.summary.presentation.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ab.vaccine.core.delegate.observer
import com.ab.vaccine.core.extensions.getStringResourceByName
import com.ab.vaccine.feature.summary.databinding.FragmentDetailsCategoryListItemBinding
import com.ab.vaccine.feature.summary.domain.model.SummaryDetailsDomainModel
import javax.inject.Inject

internal class CategoryAdapter @Inject constructor() : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var data: List<SummaryDetailsDomainModel.Series> by observer(listOf()) {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = FragmentDetailsCategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        private val itemBinding: FragmentDetailsCategoryListItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private val context = itemBinding.root.context

        fun bind(domainModel: SummaryDetailsDomainModel.Series) {
            itemBinding.tvName.text = domainModel.label.getStringResourceByName(context)
            itemBinding.tvValue.text = "${domainModel.value}"
        }
    }
}
