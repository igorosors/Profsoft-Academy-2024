package com.example.lesson_10.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.lesson_10.ui.profilesamplescreen.ProfileSampleScreen

const val PROFILE_SAMPLE_SCREEN_ROUTE = "profile_sample_screen"
private const val TRANSITION_DURATION = 300

fun NavController.navigateToProfileSampleScreen() {
    this.navigate(PROFILE_SAMPLE_SCREEN_ROUTE)
}

fun NavGraphBuilder.profileSampleScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    composable(
        route = PROFILE_SAMPLE_SCREEN_ROUTE,
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        ProfileSampleScreen(
            navController = navController,
            setBottomBarVisibility = setBottomBarVisibility,
            bottomBarHeight = bottomBarHeight,
        )
    }
}