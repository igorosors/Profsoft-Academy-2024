package com.example.lesson_10.ui.mainscreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.theme.AppTheme

@Composable
fun MainScreenContent(
    onButtonClick: () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "main screen")

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clickable(onClick = onButtonClick)
                .padding(12.dp),
            text = "navigate to info screen",
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        MainScreenContent {}
    }
}