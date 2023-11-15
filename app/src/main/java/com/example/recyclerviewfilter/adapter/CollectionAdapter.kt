package com.example.recyclerviewfilter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewfilter.data_models.Collection
import com.example.recyclerviewfilter.databinding.RecyclerviewItemBinding

class CollectionAdapter: ListAdapter<Collection, CollectionAdapter.CollectionViewHolder>( object :
    DiffUtil.ItemCallback<Collection>() {
    override fun areItemsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem == newItem
    }

}

) {

    fun setData(collection: MutableList<Collection>) {
        submitList(collection)
    }


    inner class CollectionViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val collection = currentList[adapterPosition]
                binding.apply {
                    imgGirl.setImageResource(collection.image)
                    tvTitle.text = collection.title
                    tvPrice.text = collection.price.toString()
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        return CollectionViewHolder(
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind()
    }

}
