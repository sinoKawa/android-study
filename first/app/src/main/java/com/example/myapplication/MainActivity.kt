package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        tap_here.setOnClickListener {
//            textView.text = "タップされたよ"
//        }
//        tap_here.setOnClickListener (
//            object: View.OnClickListener{
//                override fun onClick(v: View?): Unit {
//                    textView.text = "タップされたよ!!"
//                }
//            }
//        )
        tap_here.setOnClickListener ({ textView.text = "タップされたよ！！！！"})
    }
}
