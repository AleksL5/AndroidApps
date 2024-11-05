package com.example.room

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.activity.viewModels
import com.example.room.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory(WordRepository(WordDatabase.getDatabase(this).wordDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addWordButton.setOnClickListener {
            val word = binding.wordInput.text.toString().trim()
            if (word.isNotBlank() && wordViewModel.isValidWord(word)) {
                wordViewModel.addWord(word)
                binding.wordInput.text.clear()
                binding.errorMessage.visibility = View.GONE
            } else {
                binding.errorMessage.visibility = View.VISIBLE
                binding.errorMessage.text = "Введите корректное слово (только буквы и дефисы)"
            }
        }

        binding.clearWordsButton.setOnClickListener {
            wordViewModel.clearWords()
        }

        lifecycleScope.launch {
            wordViewModel.topWords.collect { words ->
                val displayText = words.joinToString("\n") { "${it.word}: ${it.count}" }
                binding.topWordsText.text = displayText
            }
        }
    }
}
