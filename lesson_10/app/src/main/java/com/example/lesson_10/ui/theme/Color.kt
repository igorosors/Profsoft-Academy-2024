package com.example.lesson_10.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

data class CustomColors(
    val blue: Color = Color(0xFF0000FF),
    val black: Color = Color(0xFF111111),
    val white: Color = Color(0xFFFFFFFF),
    val lightGray: Color = Color(0xFFD3D3D3),
)

/** это инструмент для неявной передачи данных через Composition
 * наши цвета можно запровайдить в теме и иметь к ним доступ в композабл функциях через LocalColors.current
 * @see AppTheme */

internal val LocalColors = staticCompositionLocalOf { CustomColors() }
