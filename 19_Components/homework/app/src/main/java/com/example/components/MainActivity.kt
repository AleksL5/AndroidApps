package com.example.components

import android.annotation.SuppressLint
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Patterns
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.example.components.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.checkbox1.isEnabled = false
        binding.checkbox2.isEnabled = false
        binding.button.isEnabled = false
        val toast = Toast.makeText(this, "Изменения сохранены", Toast.LENGTH_LONG)
        binding.nameText.doOnTextChanged { text, _, _, _ ->
            nameText(text)
        }

        binding.numberText.doOnTextChanged { text, _, _, _ ->
            numberText(text)
        }

        binding.radioButton1.setOnClickListener {
            binding.button.isEnabled = checkStatus()
        }

        binding.radioButton2.setOnClickListener {
            binding.button.isEnabled = checkStatus()
        }

        binding.switchMaterial.setOnClickListener {
            switchMaterial()
        }

        binding.checkbox1.setOnClickListener {
            binding.button.isEnabled = checkStatus()
        }

        binding.checkbox2.setOnClickListener {
            binding.button.isEnabled = checkStatus()
        }

        binding.progress.progress = Random.nextInt(0, 100)
        binding.scoreValueView.text = binding.progress.progress.toString()

        binding.button.setOnClickListener {
            toast.show()
        }

    }

    private fun nameText(text: CharSequence?) {
        if (!text.isNullOrEmpty()) {
            binding.nameInputLayout.isErrorEnabled = false
            binding.button.isEnabled = checkStatus()
        } else {
            binding.nameInputLayout.error = "Введите имя пользователя"
            binding.nameInputLayout.isErrorEnabled = true
            binding.button.isEnabled = checkStatus()
        }
    }

    private fun numberText(text: CharSequence?) {
        if (!text.isNullOrEmpty()) {
            binding.button.isEnabled = checkStatus()
        } else {
            binding.button.isEnabled = checkStatus()
        }
    }

    private fun switchMaterial() {
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
    }

    private fun checkStatus(): Boolean {
        return ((binding.radioButton1.isChecked || binding.radioButton2.isChecked) && (binding.checkbox1.isChecked || binding.checkbox2.isChecked) &&
                !binding.nameText.text.isNullOrEmpty() && !binding.numberText.text.isNullOrEmpty())
    }
}
