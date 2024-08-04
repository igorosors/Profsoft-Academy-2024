package com.example.lesson_10.ui.samplescreen.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.ui.components.CustomButton
import com.example.lesson_10.ui.theme.AppTheme
import java.util.UUID

@Composable
fun SampleScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val isContentVisible = remember {
            mutableStateOf(false)
        }

        val isBoxVisible = remember { mutableStateOf(false) }

        // анимирует от текущего значения до targetValue
        val alpha = animateFloatAsState(
            targetValue = if (isBoxVisible.value) 1f else 0f,
            animationSpec = spring(stiffness = Spring.StiffnessLow),
            label = "",
        )
        val randomText = remember {
            mutableStateOf(UUID.randomUUID().toString())
        }

        Text(
            modifier = Modifier
                .clickable {
                    isContentVisible.value = !isContentVisible.value
                }
                .padding(16.dp),
            text = "animate content"
        )

        CustomButton(
            modifier = Modifier.padding(16.dp),
            text = "animate float as state",
            onClick = { isBoxVisible.value = !isBoxVisible.value },
        )

        CustomButton(
            modifier = Modifier.padding(16.dp),
            text = "randomize with animated content",
            onClick = { randomText.value = UUID.randomUUID().toString() },
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .alpha(alpha.value)
                .background(Color.Black)
        )

        // можно с его помощью анимировать появление элемента
        AnimatedContent(
            targetState = isContentVisible.value,
            label = "",
        ) { isVisible ->
            if (isVisible) {
                Text(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Red),
                    text = "animated content",
                )
            }
        }

        // и так же можно анимировать сам контент
        AnimatedContent(
            targetState = randomText.value,
            transitionSpec = {
                slideInVertically { it }.togetherWith(slideOutVertically { -it })
            },
            label = "",
        ) { animatedText ->
            Text(
                modifier = Modifier.padding(16.dp),
                text = animatedText,
            )
        }
    }
}

@Preview
@Composable
private fun SampleScreenContentPreview() {
    AppTheme {
        SampleScreenContent()
    }
}