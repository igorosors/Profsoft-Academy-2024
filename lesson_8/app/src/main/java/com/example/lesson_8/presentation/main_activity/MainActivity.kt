package com.example.lesson_8.presentation.main_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_8.R
import com.example.lesson_8.presentation.flipper_activity.FlipperActivity
import com.example.lesson_8.presentation.second_activity.SecondActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonSecondActivity).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<Button>(R.id.buttonFlipperActivity).setOnClickListener {
            startActivity(Intent(this, FlipperActivity::class.java))
        }

        val adapter = MainAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter

        adapter.setItems(listOf("item 1", "item 2", "item 3", "item 4", "item 5", "item 6"))
    }
}