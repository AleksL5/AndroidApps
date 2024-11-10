package com.example.nasa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.nasa.databinding.ActivityFullScreenPhotoBinding

class FullScreenPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra(EXTRA_PHOTO_URL)

        if (imageUrl != null) {
            Glide.with(this)
                .load(imageUrl)
                .into(binding.fullScreenImageView)
        }
    }

    companion object {
        private const val EXTRA_PHOTO_URL = "photo_url"

        fun newIntent(context: Context, photoUrl: String): Intent {
            return Intent(context, FullScreenPhotoActivity::class.java).apply {
                putExtra(EXTRA_PHOTO_URL, photoUrl)
            }
        }
    }
}