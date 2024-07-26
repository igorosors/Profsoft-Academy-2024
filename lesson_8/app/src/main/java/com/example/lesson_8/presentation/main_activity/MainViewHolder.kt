package com.example.lesson_8.presentation.main_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson_8.R

class MainViewHolder(parent: ViewGroup) : ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
) {
    fun bind(text: String) {
        val textView = itemView.findViewById<TextView>(R.id.textView)

        textView.text = text
    }
}