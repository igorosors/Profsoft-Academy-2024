package com.example.lesson_10.ui.catalogscreen.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.components.CustomButton
import com.example.lesson_10.ui.theme.AppTheme

@Composable
fun CatalogScreenContent(
    onButtonClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "catalog screen")

        // remember сохраняет значение после рекомпозиции (повторного вызова composable функции)
        // mutableStateOf - стейбл стейт, который обсервит композ и повторно вызывает композабл функцию при смене значения
        val counter = remember {
            mutableIntStateOf(0)
        }

        CustomButton(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = "navigate",
            onClick = onButtonClick,
        )

        CustomButton(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = "add",
            onClick = {
                counter.intValue ++
            },
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(horizontal = 16.dp)
                .animateContentSize()
        ) {
            for (i in 0..counter.intValue) {
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(100.dp)
                ) {
                    Text(text = "123")
                }
            }
        }
    }
}

@Preview
@Composable
private fun CatalogScreenContentPreview() {
    AppTheme {
        CatalogScreenContent() {}
    }
}