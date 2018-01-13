package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.xoxgamewithkotlinmvpdagger.R
import com.example.xoxgamewithkotlinmvpdagger.R2
import com.example.xoxgamewithkotlinmvpdagger.gameActivity.GameActivity
import javax.inject.Inject

/**
 * Created by ismailgungor on 13.01.2018.
 */
class MainActivity : AppCompatActivity(), MainActivityContract.View {


    @BindView(R2.id.et_player_1)
    lateinit var etPlayer1: EditText

    @BindView(R2.id.et_player_2)
    lateinit var etPlayer2: EditText

    @BindView(R2.id.btn_start)
    lateinit var btnStart: Button

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

        btnStart.setOnClickListener {
            mPresenter.controllPlayerNames(etPlayer1.text.toString(), etPlayer2.text.toString())
        }

    }

    override fun showPlayerNameEmptyToast() {

        Toast.makeText(this, "Lütfen oyuncu isimlerini boş bırakmayınız", Toast.LENGTH_SHORT).show()

    }


    override fun goToGameActivity(player1Name: String, player2Name: String) {

        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("player1", player1Name)
        intent.putExtra("player2", player2Name)

        startActivity(intent)
        finish()
    }
}