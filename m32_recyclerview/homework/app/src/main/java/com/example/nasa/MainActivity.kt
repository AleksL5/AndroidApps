package com.example.nasa

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasa.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MarsPhotoViewModel by viewModels {
        MarsPhotoViewModelFactory(
            MarsPhotoRepository(MarsApi.retrofitService, "QbOiHsc2avEbE8wtCGuAE4rfmeOSJ95w7zEhuGWq"),
            sol = 1000 // Передаем sol, можно сделать его переменной или получить от пользователя
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MarsPhotoAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.photos.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}