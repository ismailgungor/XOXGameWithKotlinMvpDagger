package com.example.xoxgamewithkotlinmvpdagger.mainActivity

/**
 * Created by ismailgungor on 13.01.2018.
 */
interface MainActivityContract {

    interface View {


    }

    interface Presenter {

        fun setView(view: View)

    }
}