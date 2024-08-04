package com.example.lesson_10.ui.profilescreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.theme.AppTheme
import com.example.lesson_10.ui.theme.LocalColors

@Composable
fun ProfileItem(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = LocalColors.current.black,
            )
            .padding(16.dp),
        text = text,
    )
}

@Preview
@Composable
private fun ProfileItemPreview() {
    AppTheme {
        ProfileItem(text = "text")
    }
}