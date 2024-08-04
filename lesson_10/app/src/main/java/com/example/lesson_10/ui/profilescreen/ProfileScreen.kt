package com.example.lesson_10.ui.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.lesson_10.R
import com.example.lesson_10.ui.components.Toolbar
import com.example.lesson_10.ui.navigation.navigateToProfileSampleScreen
import com.example.lesson_10.ui.profilescreen.components.ProfileHeader
import com.example.lesson_10.ui.profilescreen.components.ProfileScreenContent
import com.example.lesson_10.ui.theme.LocalColors

@Composable
fun ProfileScreen(
    navController: NavController,
    setBottomBarVisibility: (Boolean) -> Unit,
    bottomBarHeight: Dp,
) {
    LaunchedEffect(Unit) {
        setBottomBarVisibility(true)
    }

    Column(
        modifier = Modifier
            .background(color = LocalColors.current.lightGray)
            .padding(bottom = bottomBarHeight)
            .fillMaxSize()
    ) {
        Toolbar(
            modifier = Modifier.background(color = LocalColors.current.white),
            title = "Profile",
            actionIconId = R.drawable.ic_star,
            onActionClick = navController::navigateToProfileSampleScreen,
        )

        ProfileScreenContent()
    }
}