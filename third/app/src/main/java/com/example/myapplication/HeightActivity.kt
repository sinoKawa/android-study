package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Spinner
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_height.*

class HeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{


                override
                fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinner = parent as? Spinner
                    var item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) height.text = it
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
        }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val heightVal = pref.getInt("HEIGHT",160)
        height.text = heightVal.toString()
        seekBar.progress = heightVal

        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    height.text = progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                   // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
        )
        radioGroup.setOnCheckedChangeListener{
            group, checkedId ->
            height.text = findViewById<RadioButton>(checkedId).text
        }
    }

    override fun onPause() {
        super.onPause()
        val pref  = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit{
            putInt("HETGHT",height.text.toString().toInt());
        }
    }
}
