package com.example.xoxgamewithkotlinmvpdagger.mainActivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.example.xoxgamewithkotlinmvpdagger.R
import com.example.xoxgamewithkotlinmvpdagger.R2
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

    }
}