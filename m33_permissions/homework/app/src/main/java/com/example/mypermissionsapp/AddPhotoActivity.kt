package com.example.mypermissionsapp

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mypermissionsapp.databinding.ActivityAddPhotoBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPhotoBinding
    private var photoUri: Uri? = null

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success && photoUri != null) {
            val currentDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
            val photo = PhotoEntity(photoUri = photoUri.toString(), dateTaken = currentDate)

            val viewModel: PhotoViewModel by viewModels()
            viewModel.insert(photo)

            Toast.makeText(this, "Фото добавлено!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Не удалось сделать фото", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTakePhoto.setOnClickListener {
            photoUri = createImageUri()
            photoUri?.let { uri -> takePicture.launch(uri) }
        }
    }

    private fun createImageUri(): Uri? {
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "Photo_${System.currentTimeMillis()}.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
    }
}