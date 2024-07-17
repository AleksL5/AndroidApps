package com.example.sharedpreference

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle


const val PREFERENCE_NAME = "preference_name"
const val SHARED_PREFS_KEY = "shared_prefs_key"


class Repository(context: Context) {

    protected var localValue: String? = null

    private var prefs = context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
    private var editor = prefs.edit()


    fun saveText(text: String) {
        editor.putString(SHARED_PREFS_KEY, text)
        editor.commit()
        localValue = text

    }

    fun clearText() {
        editor.clear()
        editor.commit()
        localValue = ""
    }

    fun getText(): String {
        return when {
            getDataFromLocalVariable() != null -> getDataFromLocalVariable()!!
            getDataFromSharedPreference() != null -> getDataFromSharedPreference()!!
            else -> "No one source doesn't contain string"
        }
    }

    private fun getDataFromSharedPreference(): String? {
        return prefs.getString(SHARED_PREFS_KEY, null)
    }


    private fun getDataFromLocalVariable(): String? {
        return localValue
    }
}