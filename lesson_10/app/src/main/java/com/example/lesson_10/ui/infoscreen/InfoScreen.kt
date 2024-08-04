package com.example.lesson_10.ui.infoscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.lesson_10.ui.infoscreen.components.InfoScreenContent

@Composable
fun InfoScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
    text: String?,
) {
    LaunchedEffect(Unit) {
        setBottomBarVisibility(true)
    }

    InfoScreenContent()
}