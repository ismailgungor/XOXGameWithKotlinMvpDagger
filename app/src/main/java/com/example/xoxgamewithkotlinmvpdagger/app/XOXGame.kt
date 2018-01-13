package com.example.xoxgamewithkotlinmvpdagger.app

import android.app.Application

/**
 * Created by ismailgungor on 13.01.2018.
 */
class XOXGame : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

    }

}