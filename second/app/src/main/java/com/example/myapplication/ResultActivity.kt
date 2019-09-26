package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    var gu = 0
    var choki = 1
    var pa = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val id = intent.getIntExtra("MY_HAND",0)
        Log.d("LOG_ID",id.toString())
        var myHand: Int
        myHand = when (id){
            R.id.gu ->{
                myHandImage.setImageResource(R.drawable.gu)
                gu
            }
            R.id.choki -> {
                myHandImage.setImageResource(R.drawable.choki)
                choki
            }
            R.id.pa -> {
                myHandImage.setImageResource(R.drawable.pa)
                pa
            } else -> gu
        }

        //androidの手札
        var comHand = (Math.random() * 3).toInt()
        when(comHand){
            gu -> comHandImage.setImageResource(R.drawable.com_gu)
            choki -> comHandImage.setImageResource(R.drawable.com_choki)
            pa -> comHandImage.setImageResource(R.drawable.com_pa)
        }

        //勝敗判定ロジック　検索
        var gameResult = (comHand - myHand + 3) % 3
        when(gameResult){
            0 -> resultLabel.setText(R.string.result_draw) //引き分け
            1 -> resultLabel.setText(R.string.result_win) //勝った場合
            2 -> resultLabel.setText(R.string.result_lose)//負けた場合
        }
        backButton.setOnClickListener { finish() }
    }
}
