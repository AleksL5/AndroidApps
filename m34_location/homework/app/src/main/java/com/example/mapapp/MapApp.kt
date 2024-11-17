package com.example.mapapp

import android.app.Application
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig

class MapApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID
    }
}