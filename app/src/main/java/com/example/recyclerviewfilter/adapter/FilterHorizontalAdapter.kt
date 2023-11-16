package com.example.recyclerviewfilter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewfilter.R
import com.example.recyclerviewfilter.data_models.Filter
import com.example.recyclerviewfilter.databinding.RecyclerviewCategoryBigItemBinding

class FilterHorizontalAdapter(val listener: (Filter) -> Unit) :
    ListAdapter<Filter, FilterHorizontalAdapter.FilterViewHolder>(object :
        DiffUtil.ItemCallback<Filter>() {
        override fun areItemsTheSame(oldItem: Filter, newItem: Filter): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Filter, newItem: Filter): Boolean {
            return oldItem == newItem
        }
    }) {
    fun setData(filter: MutableList<Filter>) {
        submitList(filter)
    }

    inner class FilterViewHolder(private val binding: RecyclerviewCategoryBigItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val filter = currentList[adapterPosition]
            binding.tvCategory.text = filter.title

            if (filter.icon == null) binding.imgIcon.visibility = View.GONE
            filter.icon?.let { binding.imgIcon.setImageResource(it) }


            binding.apply {

                root.setOnClickListener {
                    listener(filter)
                }
                if (filter.isActive) {
                    btnCategory.setBackgroundResource(R.drawable.active_category_bg)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        return FilterViewHolder(
            RecyclerviewCategoryBigItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind()
    }

}
