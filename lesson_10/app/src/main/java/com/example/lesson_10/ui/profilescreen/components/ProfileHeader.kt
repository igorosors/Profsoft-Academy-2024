package com.example.lesson_10.ui.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lesson_10.R
import com.example.lesson_10.ui.theme.AppTheme
import com.example.lesson_10.ui.theme.LocalColors
import com.example.lesson_10.ui.theme.LocalTypography

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    userName: String,
    userSurname: String,
    userDate: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LocalColors.current.white,
                shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp),
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.img_avatar),
            contentDescription = null,
        )

        Column(Modifier.padding(start = 16.dp)) {
            Text(
                text = userName,
                style = LocalTypography.current.title
            )
            Text(
                text = userSurname,
                style = LocalTypography.current.title
            )
            Text(text = userDate)
        }
    }
}

@Preview
@Composable
private fun ProfileHeaderPreview() {
    AppTheme {
        ProfileHeader(
            userName = "name",
            userSurname = "surname",
            userDate = "11.11.2011",
        )
    }
}