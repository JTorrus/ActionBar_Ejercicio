package com.example.alumne.actionbar_jtorrus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var data: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillDataToArr()
    }

    fun fillDataToArr() {
        data = ArrayList<String>()

        val stringsToUse = this.resources.getStringArray(R.array.strings_to_use)
        var item: String

        for (i in 0 until stringsToUse.size) {
            item = stringsToUse[i]
            data.add(item)
        }

    }
}
