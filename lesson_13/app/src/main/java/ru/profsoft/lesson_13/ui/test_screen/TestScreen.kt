package ru.profsoft.lesson_13.ui.test_screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.collections.immutable.ImmutableList
import org.orbitmvi.orbit.compose.collectAsState
import java.util.UUID

@Composable
fun TestScreen() {
    val viewModel: TestScreenViewModel = hiltViewModel()
    val state = viewModel.collectAsState().value

    Column {
        TestFun1(
            list = state.list,
            onClick = remember { { viewModel.test2() } },
        )
        TestFun2(testVal = state.testVal)

        Button(
            onClick = remember { { viewModel.test(UUID.randomUUID().toString()) } }
        ) {
            Text(text = "button")
        }

        TestFun3(stableObject = state.stableObject)

        Button(
            onClick = remember { { viewModel.addToStableObject() } }
        ) {
            Text(text = "add to stable object")
        }

        TestFun4(unstableObject = state.unstableObject)

        Button(
            onClick = remember { { viewModel.addToUnstableObject() } }
        ) {
            Text(text = "add to unstable object")
        }
    }
}

@Composable
fun TestFun1(
    list: ImmutableList<Int>,
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier.clickable { onClick() },
        text = list.toString()
    )
}

@Composable
fun TestFun2(testVal: String) {
    Text(text = testVal)
}

@Composable
fun TestFun3(
    stableObject: StableClass,
) {
    Log.d("qwe", "recomposition stable")
    Text(
        text = stableObject.list.toString()
    )
}

@Composable
fun TestFun4(
    unstableObject: UnstableClass,
) {
    Log.d("qwe", "recomposition unstable")
    Text(
        text = unstableObject.list.toString()
    )
}