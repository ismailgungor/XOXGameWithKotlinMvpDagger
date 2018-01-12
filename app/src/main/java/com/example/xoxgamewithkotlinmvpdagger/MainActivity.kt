package com.example.xoxgamewithkotlinmvpdagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View, View.OnClickListener {

    lateinit var buttons: Array<Button>

    @BindView(R2.id.btn1)
    lateinit var btn1: Button

    @BindView(R2.id.btn2)
    lateinit var btn2: Button

    @BindView(R2.id.btn3)
    lateinit var btn3: Button

    @BindView(R2.id.btn4)
    lateinit var btn4: Button

    @BindView(R2.id.btn5)
    lateinit var btn5: Button

    @BindView(R2.id.btn6)
    lateinit var btn6: Button

    @BindView(R2.id.btn7)
    lateinit var btn7: Button
    @BindView(R2.id.btn8)
    lateinit var btn8: Button

    @BindView(R2.id.btn9)
    lateinit var btn9: Button

    @BindView(R2.id.tv_current_player)
    lateinit var tvCurrentPlayer: TextView

    @BindView(R2.id.btn_start_again)
    lateinit var btnStartAgain: Button

    @BindView(R2.id.tv_congratulation)
    lateinit var tvCongratulation: TextView

    @Inject
    lateinit var mPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule())
                .build().inject(this)

        ButterKnife.bind(this)

        this.mPresenter.setView(this)

        buttons = arrayOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        setCurrentPlayerText("Player 1")
        startGame()

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnStartAgain.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        val selectedButton = view as Button
        mPresenter.startClickProcess(selectedButton)

    }

    override fun showChooseAnotherCellToast() {
        Toast.makeText(this, "Lütfen başka bir kare seçiniz", Toast.LENGTH_SHORT).show()
    }

    override fun setPlayer1ButtonSelected(button: Button) {

        button.setText("X")
        button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light))

    }

    override fun setPlayer2ButtonSelected(button: Button) {

        button.setText("O")
        button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light))

    }

    override fun showCongratulationsMessage(string: String) {

        tvCongratulation.setText("Tebrikler! Kazanan oyuncu " + string)

    }

    override fun finishGame() {

        hideCurrentPlayerText()
        setCurrentPlayerText("Player 1")
        showCongratulationText()
        mPresenter.setFinished(true)

    }


    override fun startGame() {
        initializeButton()

        hideCongratulationText()
        showCurrentPlayerText()

    }


    override fun setCurrentPlayerText(string: String) {

        this.tvCurrentPlayer.setText("Geçerli Oyuncu: " + string)

    }

    override fun showNoWinnerToast() {
        tvCongratulation.setText("Oyun berabere bitti!")
    }

    override fun hideCurrentPlayerText() {

        tvCurrentPlayer.visibility = View.INVISIBLE

    }

    override fun showCurrentPlayerText() {

        tvCurrentPlayer.visibility = View.VISIBLE
    }

    override fun hideCongratulationText() {

        tvCongratulation.visibility = View.INVISIBLE

    }

    override fun showCongratulationText() {

        tvCongratulation.visibility = View.VISIBLE

    }

    override fun showChooseStartAgainToast() {
        Toast.makeText(this, "Lütfen tekrar başlata basınız!", Toast.LENGTH_SHORT).show()
    }

    fun initializeButton() {


        for (button in buttons) {
            button.setText("")
            button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        }


    }
}
