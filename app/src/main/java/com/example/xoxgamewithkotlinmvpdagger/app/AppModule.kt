package com.example.xoxgamewithkotlinmvpdagger.app

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by ismailgungor on 13.01.2018.
 */
@Module
class AppModule(context: Context) {

    private var mContext: Context

    init {
        this.mContext = context
    }

    @Provides
    fun provideContext(): Context {
        return this.mContext
    }

}