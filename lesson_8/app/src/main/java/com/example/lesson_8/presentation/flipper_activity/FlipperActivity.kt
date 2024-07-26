package com.example.lesson_8.presentation.flipper_activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.lesson_8.R
import com.example.lesson_8.domain.model.LoadingState
import com.example.lesson_8.presentation.extension.toPx

class FlipperActivity : AppCompatActivity() {

    companion object {
        private const val LOADING_SCREEN = 0
        private const val SUCCESS_SCREEN = 1
        private const val ERROR_SCREEN = 2
    }

    private val viewModel: FlipperViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flipper)

        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        setupViewPager()

        findViewById<TextView>(R.id.textViewError).text = "Что-то пошло не так"
        findViewById<Button>(R.id.buttonRefresh).setOnClickListener {
            viewModel.getData()
        }

        viewModel.liveData.observe(this) { state ->
            when (state) {
                is LoadingState.Loading -> {
                    viewFlipper.displayedChild = LOADING_SCREEN
                }

                is LoadingState.Success -> {
                    viewFlipper.displayedChild = SUCCESS_SCREEN
                    val data = state.data
                }

                is LoadingState.Error -> {
                    viewFlipper.displayedChild = ERROR_SCREEN
                }
            }
        }
    }

    private fun setupViewPager() {
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val viewPagerAdapter = ViewPagerAdapter()
        with(viewPager) {
            adapter = viewPagerAdapter
            viewPagerAdapter.setItems(listOf("item 1", "item 2", "item 3", "item 4", "item 5", "item 6"))

            addItemDecoration(ViewPagerItemDecoration(4.toPx()))
            (getChildAt(0) as RecyclerView).apply {
                clipToPadding = false
                setPadding(12.toPx(), 0, 12.toPx(), 0)
            }
        }

    }
}