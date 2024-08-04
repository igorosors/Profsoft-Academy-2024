package com.example.lesson_10.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lesson_10.ui.infoscreen.InfoScreen

const val INFO_SCREEN_ROUTE = "info_screen"
private const val TRANSITION_DURATION = 300
private const val ARG_KEY = "arg_key"

fun NavController.navigateToInfoScreen(
    text: String?,
) {
    // для передачи аргументов их необходимо положить в путь экрана
    // при работе со строковым аргументом лучше использовать Uri.encode() и Uri.decode(),
    // поскольку при передаче символа '/' будет краш
    // при передаче пустой строки так же будет краш
    this.navigate("$INFO_SCREEN_ROUTE/$text")
}

fun NavGraphBuilder.infoScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    composable(
        route = "$INFO_SCREEN_ROUTE/{$ARG_KEY}",
        arguments = listOf(
            navArgument(ARG_KEY) {
                type = NavType.StringType
                nullable = true
            }
        ),
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) { backStackEntry ->
        val argument = backStackEntry.arguments?.getString(ARG_KEY)

        InfoScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
            text = argument,
        )
    }
}