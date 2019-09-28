package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        giraffeButton.setOnClickListener {
            val fragment = kirinFragment()
            var fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit()
        }
        val fragment = titleFragment as? Titlefragment
        fragment?.setTitle("図鑑画面")
    }
}
