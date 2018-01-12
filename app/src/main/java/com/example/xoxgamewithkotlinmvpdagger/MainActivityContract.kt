package com.example.xoxgamewithkotlinmvpdagger

import android.widget.Button

/**
 * Created by ismailgungor on 12.01.2018.
 */
interface MainActivityContract {

    interface View {

        fun showCongratulationsMessage(string: String)

        fun showChooseAnotherCellToast()

        fun setPlayer1ButtonSelected(button: Button)

        fun setPlayer2ButtonSelected(button: Button)

        fun finishGame()

        fun startGame()

        fun setCurrentPlayerText(string: String)

        fun showNoWinnerToast()

        fun hideCurrentPlayerText()

        fun showCurrentPlayerText()

        fun hideCongratulationText()

        fun showCongratulationText()

        fun showChooseStartAgainToast()

    }

    interface Presenter {

        fun setView(view: View)

        fun startClickProcess(button: Button)

        fun setFinished(boolean: Boolean)

    }

}