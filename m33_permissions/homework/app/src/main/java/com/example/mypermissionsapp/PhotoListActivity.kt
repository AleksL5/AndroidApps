package com.example.mypermissionsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mypermissionsapp.databinding.ActivityPhotoListBinding

class PhotoListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoListBinding
    private val viewModel: PhotoViewModel by viewModels()
    private val adapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewPhotos.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewPhotos.adapter = adapter

        viewModel.allPhotos.observe(this) { photos ->
            adapter.submitList(photos)
        }

        binding.buttonAddPhoto.setOnClickListener {
            startActivity(Intent(this, AddPhotoActivity::class.java))
        }
    }
}