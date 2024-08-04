package com.example.lesson_10.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.lesson_10.ui.samplescreen.SampleScreen
import com.example.lesson_10.ui.theme.CustomColors

const val SAMPLE_SCREEN_ROUTE = "sample_screen"

fun NavController.navigateToSampleScreen() {
    this.navigate(SAMPLE_SCREEN_ROUTE)
}

fun NavGraphBuilder.sampleScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
) {
    composable(
        route = SAMPLE_SCREEN_ROUTE
    ) {
        SampleScreen(
            navController,
            setBottomBarVisibility,
        )
    }
}