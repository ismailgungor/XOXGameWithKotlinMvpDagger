package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import javax.inject.Inject

/**
 * Created by ismailgungor on 13.01.2018.
 */
class MainActivityPresenter @Inject constructor() : MainActivityContract.Presenter {


    private lateinit var mView: MainActivityContract.View

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
}