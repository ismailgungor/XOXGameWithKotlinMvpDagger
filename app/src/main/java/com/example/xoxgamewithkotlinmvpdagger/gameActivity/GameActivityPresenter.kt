package com.example.xoxgamewithkotlinmvpdagger.gameActivity

import android.widget.Button
import com.example.xoxgamewithkotlinmvpdagger.R
import javax.inject.Inject

/**
 * Created by ismailgungor on 12.01.2018.
 */
class GameActivityPresenter @Inject constructor(gameHelper: GameHelper) : GameActivityContract.Presenter {


    private lateinit var mView: GameActivityContract.View
    private var mGameHelper: GameHelper = gameHelper
    private var playerNumber = 1
    private var isFinished = false


    override fun setView(view: GameActivityContract.View) {

        this.mView = view

    }

    override fun startClickProcess(button: Button) {

        val buttonId = button.id

        if (buttonId != R.id.btn_start_again) {

            if (!isFinished) {

                val cellId = mGameHelper.getCellId(button.id)

                if (playerNumber == 1) {

                    if (!mGameHelper.isPlayer2IncludeCellId(cellId) && !mGameHelper.isPlayer1IncludeCellId(cellId)) {

                        mView.showCurrentPlayerText()
                        mView.hideCongratulationText()
                        mGameHelper.addPlayer1CellId(cellId)
                        mView.setPlayer1ButtonSelected(button)

                        if (mGameHelper.checkWinner(playerNumber, cellId)) {
                            mView.finishGame()
                            mView.showCongratulationsMessage("player 1")
                            mGameHelper.initializeArrays()

                        } else if (!mGameHelper.isRemainCell()) {
                            mView.hideCurrentPlayerText()
                            mView.showCongratulationText()
                            mView.showNoWinnerToast()
                            setFinished(true)
                            mGameHelper.initializeArrays()

                        } else {
                            playerNumber = 2
                            mView.setCurrentPlayerText("Player 2")

                        }

                    } else {

                        mView.showChooseAnotherCellToast()

                    }


                } else {

                    if (!mGameHelper.isPlayer1IncludeCellId(cellId) && !mGameHelper.isPlayer2IncludeCellId(cellId)) {

                        mView.showCurrentPlayerText()
                        mView.hideCongratulationText()
                        mGameHelper.addPlayer2CellId(cellId)
                        mView.setPlayer2ButtonSelected(button)

                        if (mGameHelper.checkWinner(playerNumber, cellId)) {
                            mView.finishGame()
                            mView.showCongratulationsMessage("player 2")
                            mGameHelper.initializeArrays()
                            playerNumber = 1

                        } else if (!mGameHelper.isRemainCell()) {
                            mView.hideCurrentPlayerText()
                            mView.showCongratulationText()
                            mView.showNoWinnerToast()
                            mGameHelper.initializeArrays()
                            setFinished(true)
                            playerNumber = 1

                        } else {

                            playerNumber = 1
                            mView.setCurrentPlayerText("Player 1")

                        }

                    } else {

                        mView.showChooseAnotherCellToast()

                    }

                }


            } else {
                mView.showChooseStartAgainToast()
            }

        } else {
            setFinished(false)
            mView.setCurrentPlayerText("Player 1")
            mView.startGame()
            mGameHelper.initializeArrays()
            playerNumber = 1
        }


    }

    override fun setFinished(boolean: Boolean) {
        this.isFinished = boolean
    }


}