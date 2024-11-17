package com.example.mapapp

import retrofit2.HttpException
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException

class MapViewModel : ViewModel() {
    val landmarks = MutableLiveData<List<Landmark>>()
    val errorMessage = MutableLiveData<String>()

    private val apiKey = "5ae2e3f221c38a28845f05b6ce1e9e6c3ed11ee2482eb1c8bf9b00bf"

    fun loadLandmarks(lat: Double, lon: Double, radius: Int = 5000) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getLandmarks(radius, lon, lat, apiKey)
                val landmarkList = response.features.mapNotNull {
                    val coordinates = it.geometry.coordinates
                    if (it.properties.name != null && coordinates.size == 2) Landmark(
                        name = it.properties.name,
                        latitude = coordinates[1],
                        longitude = coordinates[0]
                    ) else null
                }
                landmarks.postValue(landmarkList)
            } catch (e: HttpException) {
                errorMessage.postValue("Ошибка сети: ${e.message()}")
            } catch (e: IOException) {
                errorMessage.postValue("Проблема с подключением: ${e.message}")
            }
        }
    }
}

data class Landmark(
    val name: String,
    val latitude: Double,
    val longitude: Double
)