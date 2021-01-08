package com.ab.vaccine.feature.summary.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ab.vaccine.R as ResApp
import com.ab.vaccine.core.delegate.observer
import com.ab.vaccine.core.extensions.formatToViewDateDefaults
import com.ab.vaccine.core.extensions.getStringResourceByName
import com.ab.vaccine.core.extensions.parse
import com.ab.vaccine.core.extensions.toPercent
import com.ab.vaccine.feature.summary.databinding.FragmentSummaryListItemBinding
import com.ab.vaccine.feature.summary.domain.model.SummaryDomainModel
import javax.inject.Inject

internal class SummaryAdapter @Inject constructor() : RecyclerView.Adapter<SummaryAdapter.ViewHolder>() {

    var summaryData: List<SummaryDomainModel> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private var onDebouncedClickListener: ((character: SummaryDomainModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = FragmentSummaryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(summaryData[position])
    }

    override fun getItemCount(): Int = summaryData.size

    fun setOnDebouncedClickListener(listener: (character: SummaryDomainModel) -> Unit) {
        this.onDebouncedClickListener = listener
    }

    inner class ViewHolder(
        private val itemBinding: FragmentSummaryListItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        private val context = itemBinding.root.context

        fun bind(domainModel: SummaryDomainModel) {
            itemBinding.root.setOnClickListener { onDebouncedClickListener?.invoke(domainModel) }
            itemBinding.tvArea.text = domainModel.area.getStringResourceByName(context)
            itemBinding.tvAdministrationPercent.text = domainModel.administrationPercent.toPercent()
            itemBinding.tvUpdateDate.text = "${context.getString(ResApp.string.last_update)}: ${domainModel.dateUpdate.parse()?.formatToViewDateDefaults()}"
            itemBinding.progressBar.progress = domainModel.administrationPercent.toInt()
        }
    }
}
