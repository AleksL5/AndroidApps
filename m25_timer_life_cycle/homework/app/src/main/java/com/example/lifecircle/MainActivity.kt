package com.example.lifecircle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lifecircle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val launchIntent: Intent = intent
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            if (binding.checkBox.isChecked) {
                intent.putExtra(MainActivity2.COUNT, "1")
            }
            else intent.putExtra(MainActivity2.COUNT, "0")
            startActivity(intent)
        }
        binding.textView.text = launchIntent.getStringExtra(MainActivity2.TEXT)
    }
}
