package com.example.appplaceholder_v20

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App: Application(){
    override fun onCreate() {
        super.onCreate()
    }
}