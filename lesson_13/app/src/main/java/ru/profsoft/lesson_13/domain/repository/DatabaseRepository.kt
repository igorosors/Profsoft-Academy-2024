package ru.profsoft.lesson_13.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.profsoft.lesson_13.domain.model.TestModel

interface DatabaseRepository {

    suspend fun save(test: TestModel)

    fun getTests(): List<TestModel>

    fun getTestsFlow(): Flow<List<TestModel>>
}