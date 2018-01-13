package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import android.content.Intent
import com.example.xoxgamewithkotlinmvpdagger.IntentHelper
import javax.inject.Inject

/**
 * Created by ismailgungor on 13.01.2018.
 */
class MainActivityPresenter @Inject constructor(intentHelper: IntentHelper) : MainActivityContract.Presenter {


    private lateinit var mView: MainActivityContract.View
    private var mIntentHelper: IntentHelper = intentHelper

    override fun setView(view: MainActivityContract.View) {

        this.mView = view
    }


    override fun controllPlayerNames(player1Name: String, player2Name: String) {

        if (!player1Name.equals("") && !player2Name.equals("")) {

            mView.goToGameActivity(player1Name, player2Name)

        } else {

            mView.showPlayerNameEmptyToast()
        }

    }


    override fun callGameIntent(player1Name: String, player2Name: String): Intent {

        return this.mIntentHelper.getGameActivityIntent(player1Name, player2Name)
    }
}