package com.example.lesson_8.presentation.second_activity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson_8.R

class SmallViewHolder(parent: ViewGroup) : ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.small_item, parent, false)
) {
    fun bind(item: ItemSmall) {
        val textView = itemView.findViewById<TextView>(R.id.textView)

        textView.text = item.text
    }
}