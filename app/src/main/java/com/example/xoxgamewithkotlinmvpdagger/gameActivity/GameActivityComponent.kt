package com.example.xoxgamewithkotlinmvpdagger.gameActivity

import dagger.Component
import javax.inject.Singleton

/**
 * Created by ismailgungor on 12.01.2018.
 */
@Singleton
@Component(modules = arrayOf(GameActivityModule::class))
interface GameActivityComponent {

    fun inject(gameActivity: GameActivity)

}