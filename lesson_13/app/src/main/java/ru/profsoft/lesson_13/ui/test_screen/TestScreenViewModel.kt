package ru.profsoft.lesson_13.ui.test_screen

import androidx.lifecycle.ViewModel
import coil.ImageLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import ru.profsoft.lesson_13.domain.repository.DatabaseRepository
import javax.inject.Inject

@HiltViewModel
class TestScreenViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository,
    private val imageLoader: ImageLoader,
) : ViewModel(), ContainerHost<TestScreenState, Nothing> {

    override val container = container<TestScreenState, Nothing>(TestScreenState()) {
    }

    fun test(testVal: String) = intent {
        reduce { state.copy(testVal = testVal) }
    }

    fun test2() {

    }

    fun addToStableObject() = intent {
        reduce {
            state.copy(
                stableObject = state.stableObject.copy(
                    list = state.stableObject.list
                        .toMutableList().apply { add(1) }
                )
            )
        }
    }

    fun addToUnstableObject() = intent {
        reduce {
            state.copy(
                unstableObject = state.unstableObject.copy(
                    list = state.unstableObject.list
                        .toMutableList().apply { add(1) }
                )
            )
        }
    }
}