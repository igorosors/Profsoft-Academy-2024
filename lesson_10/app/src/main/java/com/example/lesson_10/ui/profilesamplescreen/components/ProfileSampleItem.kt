package com.example.lesson_10.ui.profilesamplescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.theme.AppTheme

@Composable
fun ProfileSampleItem(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(start = 16.dp, top = 12.dp, bottom = 12.dp),
        text = text,
    )
}

@Preview
@Composable
private fun ProfileSampleItemPreview() {
    AppTheme {
        ProfileSampleItem(text = "text") {}
    }
}