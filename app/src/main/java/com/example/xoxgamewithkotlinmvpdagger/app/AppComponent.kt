package com.example.xoxgamewithkotlinmvpdagger.app

import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 13.01.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
}