package com.example.retrofitapp
data class User(
    val name: Name,
    val location: Location,
    val email: String,
    val picture: Picture
)

data class Name(val first: String, val last: String)
data class Location(val city: String, val country: String)
data class Picture(val large: String)