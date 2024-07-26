package com.example.lesson_8.presentation.second_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_8.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val adapter = SecondAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = adapter
        adapter.setItems(
            listOf(
                *listOf(ItemSmall("item 1"), ItemSmall("item 2"), ItemSmall("item 3")).toTypedArray(),
                *listOf(ItemBig("item 1"), ItemBig("item 2"), ItemBig("item 3"), ItemBig("item 4")).toTypedArray(),
            )
        )
    }
}