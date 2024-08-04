package com.example.lesson_10.ui.profilescreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreenContent() {
    val list = (0..100).toList()

    // используется для больших списков вместо RecyclerView
    // в дебаг сборке лагает, на релизной будет нормально
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        // паддинги с clipToPadding
        contentPadding = PaddingValues(bottom = 16.dp),
        // можно использовать для отступов между элементами
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // для одного айтема
        item {
            ProfileHeader(
                userName = "name",
                userSurname = "surname",
                userDate = "11.11.2000",
            )
        }

        // для списка
        items(count = list.size) { index ->
            val item = list[index]

            ProfileItem(text = item.toString())
        }
    }
}