package com.manu.memeappretrofitmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.manu.memeappretrofitmvvm.R
import com.manu.memeappretrofitmvvm.databinding.ItemMemesBinding
import com.manu.memeappretrofitmvvm.model.MemeTemplate

class MemesAdapter: ListAdapter<MemeTemplate, MemesAdapter.MemesVH>(MemesDiffUtil) {
    inner class MemesVH(val binding: ItemMemesBinding): RecyclerView.ViewHolder(binding.root)

    object MemesDiffUtil: DiffUtil.ItemCallback<MemeTemplate>() {
        override fun areItemsTheSame(oldItem: MemeTemplate, newItem: MemeTemplate): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MemeTemplate, newItem: MemeTemplate): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemesVH {
        val binding = ItemMemesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemesVH(binding)
    }

    override fun onBindViewHolder(holder: MemesVH, position: Int) {
        val item = getItem(position)
        holder.binding.ivMeme.load(item.imgUrl) {
            placeholder(R.drawable.placeholder)
        }
        holder.binding.tvTitle.text = item.caption
        holder.binding.tvId.text = item.id
    }

}