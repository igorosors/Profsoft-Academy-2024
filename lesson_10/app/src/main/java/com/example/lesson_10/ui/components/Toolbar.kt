package com.example.lesson_10.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.R
import com.example.lesson_10.ui.theme.AppTheme
import com.example.lesson_10.ui.theme.LocalTypography

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: String,
    onActionClick: (() -> Unit)? = null,
    @DrawableRes actionIconId: Int? = null,
    onBackClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        onBackClick?.let {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onBackClick)
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }

        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = title,
            style = LocalTypography.current.title,
        )

        if (onActionClick != null && actionIconId != null) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onActionClick)
                    .padding(8.dp),
                painter = painterResource(id = actionIconId),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}

@Preview
@Composable
private fun ToolbarPreview() {
    AppTheme {
        Toolbar(
            title = "title",
            onBackClick = {},
            onActionClick = {},
            actionIconId = R.drawable.ic_star,
        )
    }
}