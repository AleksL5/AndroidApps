package com.example.nasa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa.databinding.ItemMarsPhotoBinding

class MarsPhotoAdapter : PagingDataAdapter<MarsPhoto, MarsPhotoAdapter.MarsPhotoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        val binding = ItemMarsPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarsPhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val photo = getItem(position)
        if (photo != null) {
            holder.bind(photo)
        }
    }

    class MarsPhotoViewHolder(private val binding: ItemMarsPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: MarsPhoto) {
            Glide.with(binding.imageView.context)
                .load(photo.img_src)
                .into(binding.imageView)
            binding.dateTextView.text = photo.earth_date
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto) = oldItem == newItem
    }
}