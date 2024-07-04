package com.example.lifecircle

import android.app.Notification.EXTRA_TEXT
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.lifecircle.databinding.ActivityMain2Binding
import kotlinx.parcelize.Parcelize

class MainActivity2 : AppCompatActivity() {
    companion object{
        const val COUNT = "count"
        const val TEXT = "text"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding2.root)
        val launchIntent: Intent = intent
        val count = launchIntent.getStringExtra(COUNT)
        if (count.equals("1"))
            binding2.thirdNameEditText.visibility = View.VISIBLE
        else binding2.thirdNameEditText.visibility = View.INVISIBLE


        binding2.button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("text", "${binding2.secondNameEditText.text} ${binding2.nameEditText.text} ${binding2.thirdNameEditText.text}")
            startActivity(intent)
        }
    }
}
