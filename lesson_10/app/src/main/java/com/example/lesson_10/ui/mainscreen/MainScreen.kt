package com.example.lesson_10.ui.mainscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.lesson_10.ui.mainscreen.components.MainScreenContent
import com.example.lesson_10.ui.navigation.navigateToInfoScreen

@Composable
fun MainScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    // код внутри LaunchedEffect запускается по ключу
    // если передать Unit, запустится один раз при открытии экрана
    LaunchedEffect(key1 = Unit) {
        setBottomBarVisibility(true)
    }

    MainScreenContent(
        onButtonClick = { navController.navigateToInfoScreen(null) }
    )
}