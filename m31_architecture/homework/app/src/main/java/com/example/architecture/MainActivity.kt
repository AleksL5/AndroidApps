package com.example.architecture

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.architecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.tvActivity.text = ""
                    }
                    is UiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvActivity.text = uiState.activity.activity
                    }
                    is UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvActivity.text = uiState.message
                    }
                }
            }
        }

        binding.btnGetActivity.setOnClickListener {
            viewModel.reloadUsefulActivity()
        }
    }
}