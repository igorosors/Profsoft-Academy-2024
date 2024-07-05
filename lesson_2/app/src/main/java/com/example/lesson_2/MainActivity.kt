package com.example.lesson_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_KEY = "extra_key"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonNavigate)
        Toast.makeText(this, "notification", Toast.LENGTH_LONG).show()

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_KEY, "some text")
            }
            startActivity(intent)
        }
    }
}