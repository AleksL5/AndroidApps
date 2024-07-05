package com.example.lifecircle

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.icu.text.IDNA
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lifecircle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        var count = "" // Значение для определения статуса checkbox

    }
    private lateinit var binding: ActivityMainBinding


    private val authLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            when (result.resultCode) {
                Activity.RESULT_OK -> {
                    val intentData: Intent? = result.data
                    ?: return@registerForActivityResult
                    val info : PersonInfo = intentData?.let {
                        IntentCompat.getParcelableExtra(it, MainActivity2.INFO, PersonInfo::class.java)
                    } ?: return@registerForActivityResult
                    binding.secondNameTextView.text = info.secondName
                    binding.nameTextView.text = info.name
                    binding.thirdNameTextView.text = info.thirdName
                }
                MainActivity2.AUTH_FAILED -> {
                    Toast.makeText(this, R.string.auth_failed, Toast.LENGTH_LONG).show()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnClickListener {
            checkBoxStatus()
        }
        binding.button.setOnClickListener {
            authLauncher.launch(Intent(this, MainActivity2::class.java))
        }
    }
    private fun checkBoxStatus(){
        count = if (binding.checkBox.isChecked) "1" else "0"
    }
//    override fun onStart() {
//        super.onStart()
//        Log.d("Счётчик", "onStart")
//    }
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.d("Счётчик", "onRestoreInstanceState")
//    }
//    override fun onResume() {
//        super.onResume()
//        Log.d("Счётчик", "onResume")
//    }
//    override fun onPause() {
//        super.onPause()
//        Log.d("Счётчик", "onPause")
//    }
//    override fun onStop() {
//        super.onStop()
//        Log.d("Счётчик", "onStop")
//    }
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Log.d("Счётчик", "onSaveInstanceState")
////        outState.putInt(COUNTER, counter)
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("Счётчик", "onDestroy")
//    }
}


