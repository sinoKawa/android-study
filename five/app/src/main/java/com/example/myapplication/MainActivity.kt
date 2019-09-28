package com.example.myapplication

import android.media.AsyncPlayer
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.adapter =MyAdapter(supportFragmentManager)
        val handler = Handler()
        timer(period = 5000){
            handler.post{
                pager.currentItem = (pager.currentItem + 1) % 10
            }
        }
        player = MediaPlayer.create(this,R.raw.getdown)
        player.isLooping = true
    }

    override fun onResume() {
        super.onResume()
        player.start()
    }

    override fun onPause() {
        super.onPause()
        player.pause()
    }

    private lateinit var player: MediaPlayer

    class MyAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
        private val resource = listOf(
            R.drawable.slide00,            R.drawable.slide01,
            R.drawable.slide02,            R.drawable.slide03,
            R.drawable.slide04,            R.drawable.slide05,
            R.drawable.slide06,            R.drawable.slide09,
            R.drawable.slide08,            R.drawable.slide09
        )


        override fun getItem(position: Int): Fragment {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return ImageFragment.newInstance(resource[position])
        }

        override fun getCount(): Int {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return resource.size
        }

    }
}
