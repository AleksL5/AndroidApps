package com.example.lifecircle

import android.app.Activity
import android.app.Notification.EXTRA_TEXT
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.lifecircle.databinding.ActivityMain2Binding
import kotlinx.parcelize.Parcelize

class MainActivity2 : AppCompatActivity() {
    companion object {
        const val INFO = "INFO"
        const val AUTH_FAILED = 10

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding2.root)
        if (MainActivity.count.equals("1"))
            binding2.thirdNameEditText.visibility = VISIBLE
        else binding2.thirdNameEditText.visibility = INVISIBLE

        binding2.button2.setOnClickListener {
                val personInfo = PersonInfo(
                    secondName = binding2.secondNameEditText.text.toString(),
                    name = binding2.nameEditText.text.toString(),
                    thirdName = binding2.thirdNameEditText.text.toString()
                )
                val data = Intent()
                data.putExtra(INFO, personInfo)
                setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}

    @Parcelize
    class PersonInfo(
        val secondName:String,
        val name:String,
        val thirdName:String,
    ): Parcelable
