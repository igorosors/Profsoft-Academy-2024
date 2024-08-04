package com.example.lesson_10.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.theme.AppTheme
import com.example.lesson_10.ui.theme.LocalColors

const val FIRST_TAB = 0
const val SECOND_TAB = 1
const val THIRD_TAB = 2

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    onTabClick: (pos: Int) -> Unit,
) {
    val blackColor = LocalColors.current.black

    Row(
        modifier = modifier
            .heightIn(max = 64.dp)
            .background(color = LocalColors.current.white)
            .drawBehind {
                drawLine(
                    color = blackColor,
                    strokeWidth = 1.dp.toPx(),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                )

                drawRect(
                    brush = Brush.verticalGradient(
                        0f to Color(0x00000000),
                        1f to blackColor,
                    )
                )
            }
    ) {
        BottomNavigationItem(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable { onTabClick(FIRST_TAB) },
            text = "tab 1",
        )

        Spacer(Modifier.width(8.dp))

        BottomNavigationItem(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable { onTabClick(SECOND_TAB) },
            text = "tab 2",
        )

        Spacer(Modifier.width(8.dp))

        BottomNavigationItem(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable { onTabClick(THIRD_TAB) },
            text = "tab 3",
        )
    }
}

@Composable
private fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier
            .padding(12.dp),
        text = text,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    AppTheme {
        BottomNavigation {}
    }
}