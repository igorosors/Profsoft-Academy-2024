package com.example.lesson_10.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val THIRD_TAB_HOST_ROUTE = "third_tab_host"

fun NavController.navigateToThirdTab() {
    this.navigate(THIRD_TAB_HOST_ROUTE) {
        popUpTo(FIRST_TAB_HOST_ROUTE) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.thirdTabHost(
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    composable(
        route = THIRD_TAB_HOST_ROUTE
    ) {
        val navController = rememberNavController()

        ThirdTabHost(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}

@Composable
private fun ThirdTabHost(
    navController: NavHostController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = PROFILE_SCREEN_ROUTE,
    ) {
        profileScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )

        profileSampleScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}