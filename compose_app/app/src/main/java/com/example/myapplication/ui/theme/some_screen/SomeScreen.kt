package com.example.myapplication.ui.theme.some_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.some_screen.components.UserHeaderComponent
import com.example.myapplication.ui.theme.some_screen.components.UserInfo

@Composable
fun SomeScreen() {
    SomeScreenContent(
        userName = "name",
        userSurname = "surname",
        userDate = "11.11.2011",
        userinfo = "some info",
    )
}

@Composable
private fun SomeScreenContent(
    userName: String,
    userSurname: String,
    userDate: String,
    userinfo: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserHeaderComponent(
            userName = userName,
            userSurname = userSurname,
            userDate = userDate,
        )

        UserInfo(
            modifier = Modifier.padding(vertical = 12.dp),
            info = userinfo,
        )
    }
}

@Preview
@Composable
private fun SomeScreenPreview() {
    SomeScreenContent(
        userName = "name",
        userSurname = "surname",
        userDate = "11.11.2011",
        userinfo = "some info",
    )
}