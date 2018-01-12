package com.example.xoxgamewithkotlinmvpdagger

import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 12.01.2018.
 */
@Singleton
@Component(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}