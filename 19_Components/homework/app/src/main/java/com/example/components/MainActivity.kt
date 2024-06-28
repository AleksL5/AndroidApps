package com.example.components

import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.example.components.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random
import android.widget.CheckBox
import androidx.core.view.isGone
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.checkbox1.isEnabled = false
        binding.checkbox2.isEnabled = false
        binding.button.isEnabled = false
        binding.nameText.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty())
                binding.nameInputLayout.isErrorEnabled = false
            else {
                binding.nameInputLayout.error = "Введите имя пользователя"
                binding.nameInputLayout.isErrorEnabled = true
            }
        }

        binding.switchMaterial.setOnClickListener {
            if (binding.switchMaterial.isChecked) {
                binding.checkbox1.isEnabled = true
                binding.checkbox2.isEnabled = true
            }
            if (!binding.switchMaterial.isChecked) {
                binding.checkbox1.isEnabled = false
                binding.checkbox1.isChecked = false
                binding.checkbox2.isEnabled = false
                binding.checkbox2.isChecked = false
            }
            if ((binding.radioButton1.isChecked || binding.radioButton2.isChecked))
            binding.button.isEnabled = true
        }
            binding.progress.progress = Random.nextInt(0, 100)
            binding.scoreValueView.text = binding.progress.progress.toString()

    }
}
// Дополнительные условия которые не получается интегрировать в 47 строку
//&& (binding.checkbox1.isChecked || binding.checkbox2.isChecked) &&
//!binding.nameText.text.isNullOrEmpty() && !binding.numberText.text.isNullOrEmpty()