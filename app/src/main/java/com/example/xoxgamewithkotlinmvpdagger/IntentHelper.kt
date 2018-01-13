package com.example.xoxgamewithkotlinmvpdagger

import android.content.Context
import android.content.Intent
import com.example.xoxgamewithkotlinmvpdagger.gameActivity.GameActivity

/**
 * Created by ismailgungor on 13.01.2018.
 */
class IntentHelper(context: Context) {

    private var mContext: Context

    init {
        this.mContext = context
    }


    fun getGameActivityIntent(player1Name: String, player2Name: String): Intent {

        val gameIntent = Intent(mContext, GameActivity::class.java)
        gameIntent.putExtra("player1", player1Name)
        gameIntent.putExtra("player2", player2Name)

        return gameIntent
    }

}