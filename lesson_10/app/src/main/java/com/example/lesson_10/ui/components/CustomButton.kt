package com.example.lesson_10.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.theme.AppTheme
import com.example.lesson_10.ui.theme.LocalColors

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .background(
                color = LocalColors.current.blue,
            )
            .padding(12.dp),
        text = text,
    )
}

@Preview
@Composable
private fun ButtonPreview() {
    AppTheme {
        CustomButton(text = "text") {}
    }
}