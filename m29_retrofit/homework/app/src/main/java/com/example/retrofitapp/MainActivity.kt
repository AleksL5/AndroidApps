package com.example.retrofitapp


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.retrofitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.user.observe(this, Observer { user ->
            if (user != null) {

                binding.userName.text = "${user.name.first} ${user.name.last}"
                binding.userLocation.text = "${user.location.city}, ${user.location.country}"
                binding.userEmail.text = user.email


                Glide.with(this)
                    .load(user.picture.large)
                    .into(binding.userImage)
            }
        })


        binding.refreshButton.setOnClickListener {
            viewModel.loadUser()
        }


        viewModel.loadUser()
    }
}