package ru.profsoft.lesson_13.ui.test_screen

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class TestScreenState(
    val list: ImmutableList<Int> = persistentListOf(1, 2, 3, 4, 5),
    val testVal: String = "",
    val stableObject: StableClass = StableClass(),
    val unstableObject: UnstableClass = UnstableClass(),
)

@Stable
data class StableClass(
    val list: List<Int> = listOf(1, 2, 3, 4, 5),
)

data class UnstableClass(
    val list: List<Int> = listOf(1, 2, 3, 4, 5),
)
