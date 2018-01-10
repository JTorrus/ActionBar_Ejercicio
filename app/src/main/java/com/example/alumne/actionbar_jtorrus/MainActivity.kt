package com.example.alumne.actionbar_jtorrus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var data: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListView()
    }

    fun fillDataToArr(): ArrayList<String> {
        data = ArrayList<String>()

        val stringsToUse = this.resources.getStringArray(R.array.strings_to_use)
        var item: String

        for (i in 0 until stringsToUse.size) {
            item = stringsToUse[i]
            data.add(item)
        }

        return data
    }

    fun showListView() {
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, fillDataToArr())
        list_view.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (super.onCreateOptionsMenu(menu)) {
            menuInflater.inflate(R.menu.menu, menu)
            return true
        } else {
            return false
        }
    }
}
