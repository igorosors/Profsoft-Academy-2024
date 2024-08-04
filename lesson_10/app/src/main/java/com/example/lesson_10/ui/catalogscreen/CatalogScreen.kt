package com.example.lesson_10.ui.catalogscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.lesson_10.ui.catalogscreen.components.CatalogScreenContent
import com.example.lesson_10.ui.navigation.navigateToSampleScreen

@Composable
fun CatalogScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
) {
    LaunchedEffect(Unit) {
        setBottomBarVisibility(true)
    }

    CatalogScreenContent() { navController.navigateToSampleScreen() }
}