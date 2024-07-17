package com.example.sharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.databinding.ActivityMainBinding

const val BUNDLE_KEY = "bundle_key"

class MainActivity : AppCompatActivity() {

    private lateinit var vb: ActivityMainBinding

    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        repository = Repository(this)

        vb.textView.text = repository.getText()

        vb.btnSave.setOnClickListener {
            val text = vb.editText.text.toString()
            repository.saveText(text)
            vb.textView.text = repository.getText()

        }

        vb.btnClear.setOnClickListener {
            repository.clearText()
            vb.textView.text = repository.getText()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(BUNDLE_KEY, repository.getText())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString(BUNDLE_KEY)
    }
}