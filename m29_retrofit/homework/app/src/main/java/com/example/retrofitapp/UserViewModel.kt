package com.example.retrofitapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    fun loadUser() {
        repository.fetchRandomUser { fetchedUser ->
            _user.postValue(fetchedUser)
        }
    }
}