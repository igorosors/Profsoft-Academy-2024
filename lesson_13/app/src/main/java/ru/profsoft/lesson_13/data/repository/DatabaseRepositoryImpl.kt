package ru.profsoft.lesson_13.data.repository

import kotlinx.coroutines.flow.Flow
import ru.profsoft.lesson_13.data.database.MyDatabase
import ru.profsoft.lesson_13.data.database.entity.TestEntity
import ru.profsoft.lesson_13.domain.model.TestModel
import ru.profsoft.lesson_13.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val database: MyDatabase,
): DatabaseRepository {
    override suspend fun save(test: TestModel) {
        database.testDao().save(
            TestEntity(
                id = 0,
                title = test.title
            )
        )
    }

    override fun getTests(): List<TestModel> {
        TODO("Not yet implemented")
    }

    override fun getTestsFlow(): Flow<List<TestModel>> {
        TODO("Not yet implemented")
    }
}