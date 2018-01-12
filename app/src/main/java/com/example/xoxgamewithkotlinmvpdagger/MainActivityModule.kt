package com.example.xoxgamewithkotlinmvpdagger

import dagger.Module
import dagger.Provides

/**
 * Created by ismailgungor on 12.01.2018.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideGameHelper(): GameHelper {
        return GameHelper()
    }

}