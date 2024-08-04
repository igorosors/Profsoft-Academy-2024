package com.example.lesson_10.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val SECOND_TAB_HOST_ROUTE = "second_tab_host"

fun NavController.navigateToSecondTab() {
    this.navigate(SECOND_TAB_HOST_ROUTE) {
        popUpTo(FIRST_TAB_HOST_ROUTE) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.secondTabHost(
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    composable(
        route = SECOND_TAB_HOST_ROUTE
    ) {
        val navController = rememberNavController()

        SecondTabHost(
            navController,
            setBottomBarVisibility,
            bottomBarHeight,
        )
    }
}

@Composable
private fun SecondTabHost(
    navController: NavHostController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = CATALOG_SCREEN_ROUTE,
    ) {
        catalogScreen(
            navController,
            setBottomBarVisibility,
            bottomBarHeight,
        )

        sampleScreen(
            navController,
            setBottomBarVisibility,
        )
    }
}