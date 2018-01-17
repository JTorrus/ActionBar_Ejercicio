package com.example.alumne.actionbar_jtorrus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var data: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showListView()
    }

    private fun fillDataToArr(): ArrayList<String> {
        data = ArrayList<String>()

        val stringsToUse = this.resources.getStringArray(R.array.strings_to_use)
        var item: String

        for (i in 0 until stringsToUse.size) {
            item = stringsToUse[i]
            data.add(item)
        }

        return data
    }

    private fun showListView() {
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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_add -> {
                addRandomItem(Random(), "abcdefgh", 5);
                true
            }

            R.id.action_search -> {
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun addRandomItem(rng: Random, characters: String, length: Int) {
        val text = CharArray(length)
        for (i in 0 until length) {
            text[i] = characters[rng.nextInt(characters.length)]
        }

        data.add(String(text))
        val adapter = list_view.adapter as ArrayAdapter<String>

        adapter.notifyDataSetChanged()
        list_view.smoothScrollToPosition(data.size-1)
    }
}
