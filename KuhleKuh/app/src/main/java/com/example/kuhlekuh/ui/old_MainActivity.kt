/*
package com.example.kuhmuh

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import java.text.DateFormat
import java.util.*

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    private var mDisplayDate: TextView? = null
    private var onDateSetListener: DatePickerDialog.OnDateSetListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDisplayDate = findViewById<View>(R.id.tvDate) as TextView */
/** Hier noch zweites Select Date einfügen mit id:tvDate2 *//*

        mDisplayDate!!.setOnClickListener {
            val cal = Calendar.getInstance()
            val year = cal[Calendar.YEAR]
            val month = cal[Calendar.MONTH]
            val day = cal[Calendar.DAY_OF_MONTH]
            val dialog = DatePickerDialog(
                this@MainActivity,
                android.R.style.Theme_Black,
                onDateSetListener,
                year, month, day
            )
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
        onDateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            Log.d(
                TAG,
                "onDateSet: date: $year/$month/$dayOfMonth"
            )
        }
    }
    companion object {
        private const val TAG = "MainActivity"
    }



}
*/
