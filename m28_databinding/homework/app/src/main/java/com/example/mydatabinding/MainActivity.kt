package com.example.mydatabinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mydatabinding.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<FragmentMainBinding>(this,R.layout.activity_main)

        val binding = FragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}