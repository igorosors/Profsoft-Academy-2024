package com.example.lesson_10.ui.profilesamplescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.lesson_10.ui.components.Toolbar
import com.example.lesson_10.ui.profilesamplescreen.components.ProfileSampleScreenContent

@Composable
fun ProfileSampleScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    LaunchedEffect(Unit) {
        setBottomBarVisibility(true)
    }

    Column(Modifier.padding(bottom = bottomBarHeight)) {
        Toolbar(
            title = "title",
            onBackClick = navController::popBackStack,
        )

        ProfileSampleScreenContent()
    }
}