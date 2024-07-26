package com.example.lesson_8.presentation.second_activity

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SecondAdapter : Adapter<ViewHolder>() {
    companion object {
        private const val SMALL_ITEM = 0
        private const val BIG_ITEM = 1
    }

    private val items = mutableListOf<AdapterItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            SMALL_ITEM -> SmallViewHolder(parent)
            BIG_ITEM -> BigViewHolder(parent)
            else -> throw Exception("incorrect view type")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            SMALL_ITEM -> (holder as SmallViewHolder).bind(items[position] as ItemSmall)
            BIG_ITEM -> (holder as BigViewHolder).bind(items[position] as ItemBig)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is ItemSmall) SMALL_ITEM else BIG_ITEM
    }

    fun setItems(items: List<AdapterItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}