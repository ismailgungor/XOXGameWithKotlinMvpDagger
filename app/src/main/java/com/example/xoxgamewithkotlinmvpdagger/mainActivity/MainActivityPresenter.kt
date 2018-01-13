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
}