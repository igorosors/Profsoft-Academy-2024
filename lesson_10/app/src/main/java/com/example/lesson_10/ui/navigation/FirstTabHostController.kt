package com.example.lesson_10.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val FIRST_TAB_HOST_ROUTE = "first_tab_host"

fun NavController.navigateToFirstTab() {
    this.navigate(FIRST_TAB_HOST_ROUTE) {
        popUpTo(FIRST_TAB_HOST_ROUTE) {
            // при навигации между табами убираем всё из бек стека и сохраняем
            // это позволяет восстанавливать стек вкладки при навигации на нее
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.firstTabHost(
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    composable(
        route = FIRST_TAB_HOST_ROUTE,
    ) {
        // Один нав хост, один нав контроллер
        // создаем новый нав контроллер для нового нав хоста
        val navController = rememberNavController()

        FirstTabHost(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}

@Composable
private fun FirstTabHost(
    navController: NavHostController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN_ROUTE,
    ) {
        mainScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )

        infoScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}
