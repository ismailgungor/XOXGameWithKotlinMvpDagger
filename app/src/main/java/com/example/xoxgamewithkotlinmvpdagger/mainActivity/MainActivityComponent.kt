package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 13.01.2018.
 */
@Singleton
@Component(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}