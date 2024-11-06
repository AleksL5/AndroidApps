package com.example.architecture

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "activities")
data class UsefulActivityDto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("activity") override val activity: String,
    @SerializedName("type") override val type: String,
    @SerializedName("participants") override val participants: Int,
    @SerializedName("price") override val price: Float
) : UsefulActivity