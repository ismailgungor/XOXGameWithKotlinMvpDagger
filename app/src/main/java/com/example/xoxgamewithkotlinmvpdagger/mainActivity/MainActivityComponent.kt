package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import com.example.xoxgamewithkotlinmvpdagger.app.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 13.01.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, MainActivityModule::class))
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}