package com.example.lesson_10.ui.infoscreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lesson_10.ui.theme.AppTheme

@Composable
fun InfoScreenContent() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "info screen")
    }
}

@Preview
@Composable
private fun InfoScreenContentPreview() {
    AppTheme {
        InfoScreenContent()
    }
}