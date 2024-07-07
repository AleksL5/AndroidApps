package com.example.lifecircle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BundleCompat
import com.example.lifecircle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var person = PersonInfo("", "", "")

    private val authLauncher =
        registerForActivityResult(CustomActivityResultContract()) { result: PersonInfo? ->

                    result?.let {
                        person = it
                        binding.textView.text = "${it.secondName} ${it.name} ${it.patronymic}"
                }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            authLauncher.launch(binding.checkBox.isChecked)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("Счётчик", "onSaveInstanceState")
        outState.putParcelable(CustomActivityResultContract.PERSON_INFO, person)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("Счётчик", "onRestoreInstanceState")
            savedInstanceState.let {
                person = BundleCompat.getParcelable(it, CustomActivityResultContract.PERSON_INFO, PersonInfo::class.java) ?: person
                binding.textView.text = "${person.secondName} ${person.name} ${person.patronymic}"
            }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Счётчик", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Счётчик", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Счётчик", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Счётчик", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Счётчик", "onDestroy")
    }
}


