package com.example.mycustomactivity

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycustomactivity.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.customView.setTopMessageText("Верхняя строчка, настроенная из кода")
        binding.customView.setBottomMessageText("Нижняя строчка, настроенная из кода")
        binding.customView.changeBackgroundColor(Color.RED)

    }
}