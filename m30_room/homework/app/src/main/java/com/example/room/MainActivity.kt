package com.example.room

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.room.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WordViewModel by viewModels {
        WordViewModelFactory(WordDatabase.getDatabase(this).wordDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddWord.setOnClickListener {
            val word = binding.inputWord.text.toString()
            if (viewModel.isValidWord(word)) {
                viewModel.addWord(word)
                binding.inputWord.text.clear()
            } else {
                Toast.makeText(this, "Введите корректное слово", Toast.LENGTH_SHORT).show()
            }
        }

        lifecycleScope.launch {
            viewModel.topWords.collect { words ->
                val displayText = words.joinToString(separator = "\n") { "${it.word}: ${it.count}" }
                binding.tvTopWords.text = displayText
            }
        }

        binding.btnClearWords.setOnClickListener {
            viewModel.clearWords()
        }
    }
}