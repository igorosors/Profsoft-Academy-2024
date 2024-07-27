package com.example.myapplication.ui.theme.some_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Любая композабл функция должна содержать аннотацию Composable
@Composable
fun UserHeaderComponent(
    // делать модифаер для компонентов - хорошая практика
    // используетя для настройки компонента
    // отступы, фон, ширина, высота и тд
    modifier: Modifier = Modifier,
    userName: String,
    userSurname: String,
    userDate: String,
) {
    // используется для конвертации px в dp
    val density = LocalDensity.current
    // remember сохраняет значение после рекомпозиции,
    // т.е после переотрисовки компонента
    val width = remember { mutableStateOf(0.dp) }

    Column(
        modifier = modifier
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
            )
            // порядок модифаеров очень важен
            // сначала устанавливается бекграунд, потом паддинг
            // если их поменять местами, будет другой результат
            .padding(16.dp)
            .width(IntrinsicSize.Min)

    ) {
        Text(
            modifier = Modifier
                // можно использовать для получения размера элемента
                .onGloballyPositioned { layoutCoordinates ->
                    with(density) {
                        width.value = layoutCoordinates.size.width.toDp()
                    }
                },
            style = TextStyle(
                color = Color.Blue,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            ),
            text = userName
        )

        Text(
            modifier = Modifier.width(width.value),
            text = userSurname
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = userDate,
        )
    }
}

// аннотация для создания превью композабл функций
@Preview
@Composable
private fun UserHeaderComponentPreview() {
    UserHeaderComponent(
        userName = "Ivan238478322323232",
        userSurname = "Ivanov",
        userDate = "21.11.2010"
    )
}