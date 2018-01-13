package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import android.content.Intent

/**
 * Created by ismailgungor on 13.01.2018.
 */
interface MainActivityContract {

    interface View {

        fun showPlayerNameEmptyToast()

        fun goToGameActivity(player1Name: String, player2Name: String)

    }

    interface Presenter {

        fun setView(view: View)

        fun controllPlayerNames(player1Name: String, player2Name: String)

        fun callGameIntent(player1Name: String, player2Name: String): Intent

    }
}