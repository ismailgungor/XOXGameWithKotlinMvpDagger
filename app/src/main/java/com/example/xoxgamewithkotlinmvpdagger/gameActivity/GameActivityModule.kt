package com.example.xoxgamewithkotlinmvpdagger.gameActivity

import dagger.Module
import dagger.Provides

/**
 * Created by ismailgungor on 12.01.2018.
 */
@Module
class GameActivityModule {

    @Provides
    fun provideGameHelper(): GameHelper {
        return GameHelper()
    }

}