package com.example.kuhmuh

import android.content.SharedPreferences
import android.preference.PreferenceManager


/*class MainActivity : AppCompatActivity() {
    private var mDisplayDate: TextView? = null
    private var onDateSetListener: OnDateSetListener? = null
    override fun onCreate(savedInstandeState: Bundle?) {
        super.onCreate(savedInstandeState)
        setContentView(R.layout.activity_main)
        mDisplayDate = findViewById<View>(R.id.tvDate) as TextView
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
            dialog.window
                .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
        onDateSetListener = OnDateSetListener { view, year, month, dayOfMonth ->
            Log.d(
                MainActivity.Companion.TAG,
                "onDateSet: date: $year/$month/$dayOfMonth"
            )
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}*/


