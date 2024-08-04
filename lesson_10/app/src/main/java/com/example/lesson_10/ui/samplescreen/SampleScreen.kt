package com.example.lesson_10.ui.samplescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.lesson_10.ui.components.Toolbar
import com.example.lesson_10.ui.samplescreen.components.SampleScreenContent

@Composable
fun SampleScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        setBottomBarVisibility(false)
    }

    Column {
        Toolbar(
            title = "sample screen",
            onBackClick = navController::popBackStack,
        )

        SampleScreenContent()
    }
}