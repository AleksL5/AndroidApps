package com.example.lifecircle

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PersonInfo(
    val secondName:String,
    val name:String,
    val patronymic:String,
): Parcelable