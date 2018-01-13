package com.example.xoxgamewithkotlinmvpdagger.gameActivity

import android.content.Intent
import android.widget.Button

/**
 * Created by ismailgungor on 12.01.2018.
 */
interface GameActivityContract {

    interface View {

        fun showChooseAnotherCellToast()

        fun setPlayer1ButtonSelected(button: Button)

        fun setPlayer2ButtonSelected(button: Button)

        fun finishGame()

        fun startGame()

        fun showNoWinnerToast()

        fun hideCurrentPlayerText()

        fun showCurrentPlayerText()

        fun hideCongratulationText()

        fun showCongratulationText()

        fun showChooseStartAgainToast()

        fun setPlayer1Name(player1Name: String)

        fun setPlayer2Name(player2Name: String)

        fun setCurrentPlayer1Text()

        fun setCurrentPlayer2Text()

        fun setPlayer1CongratulationsText()

        fun setPlayer2CongratulationsText()

    }

    interface Presenter {

        fun setView(view: View)

        fun startClickProcess(button: Button)

        fun setFinished(boolean: Boolean)

        fun callMainActivityIntent(): Intent

        fun controllPlayerNamesFromIntent(intent: Intent?)

    }

}