package com.example.lesson_10.ui.profilesamplescreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lesson_10.ui.theme.AppTheme

@Composable
fun ProfileSampleScreenContent() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        for (i in 0..15) {
            ProfileSampleItem(
                text = "text $i",
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun ProfileSampleScreenContentPreview() {
    AppTheme {
        ProfileSampleScreenContent()
    }
}