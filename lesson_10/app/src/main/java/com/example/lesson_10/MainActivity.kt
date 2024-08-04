package com.example.lesson_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.lesson_10.ui.components.BottomNavigation
import com.example.lesson_10.ui.components.FIRST_TAB
import com.example.lesson_10.ui.components.SECOND_TAB
import com.example.lesson_10.ui.components.THIRD_TAB
import com.example.lesson_10.ui.navigation.FIRST_TAB_HOST_ROUTE
import com.example.lesson_10.ui.navigation.NavHost
import com.example.lesson_10.ui.navigation.navigateToFirstTab
import com.example.lesson_10.ui.navigation.navigateToSecondTab
import com.example.lesson_10.ui.navigation.navigateToThirdTab
import com.example.lesson_10.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val isBottomBarVisible = remember { mutableStateOf(false) }

            val navController = rememberNavController()

            AppTheme {
                Scaffold(
                    containerColor = Color.Transparent,
                    bottomBar = {
                        AnimatedVisibility(
                            visible = isBottomBarVisible.value,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically(),
                        ) {
                            BottomNavigation { tab ->
                                when (tab) {
                                    FIRST_TAB -> navController.navigateToFirstTab()
                                    SECOND_TAB -> navController.navigateToSecondTab()
                                    THIRD_TAB -> navController.navigateToThirdTab()
                                }
                            }
                        }
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        bottomBarHeight = paddingValues.calculateBottomPadding(),
                        setBottomBarVisibility = { isBottomBarVisible.value = it },
                        startDestination = FIRST_TAB_HOST_ROUTE,
                    )
                }
            }
        }
    }
}