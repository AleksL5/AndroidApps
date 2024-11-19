package com.example.mypermissionsapp

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypermissionsapp.databinding.ItemPhotoBinding

class PhotoAdapter : ListAdapter<PhotoEntity, PhotoAdapter.PhotoViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PhotoViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: PhotoEntity) {
            Glide.with(binding.imageViewPhoto.context)
                .load(Uri.parse(photo.photoUri))
                .into(binding.imageViewPhoto)

            binding.textViewPhotoDate.text = photo.dateTaken
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PhotoEntity>() {
        override fun areItemsTheSame(oldItem: PhotoEntity, newItem: PhotoEntity) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PhotoEntity, newItem: PhotoEntity) = oldItem == newItem
    }
}