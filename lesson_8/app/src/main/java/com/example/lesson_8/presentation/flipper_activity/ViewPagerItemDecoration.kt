package com.example.lesson_8.presentation.flipper_activity

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_8.presentation.extension.toPx

class ViewPagerItemDecoration(private var space: Int = 4.toPx()) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.left = space
        outRect.right = space
    }
}