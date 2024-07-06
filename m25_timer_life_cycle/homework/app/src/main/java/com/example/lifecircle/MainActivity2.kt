package com.example.lifecircle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.lifecircle.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding2.root)
        val checkBoxStatus =
            intent.getBooleanExtra(CustomActivityResultContract.CHECKBOX_STATUS, false)
        if (checkBoxStatus) binding2.thirdNameEditText.visibility = VISIBLE
        else binding2.thirdNameEditText.visibility = INVISIBLE

        binding2.button2.setOnClickListener {
            val personInfo = PersonInfo(
                secondName = binding2.secondNameEditText.text.toString(),
                name = binding2.nameEditText.text.toString(),
                patronymic = binding2.thirdNameEditText.text.toString()
            )
            val data = Intent()
            data.putExtra(CustomActivityResultContract.PERSON_INFO, personInfo)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}

