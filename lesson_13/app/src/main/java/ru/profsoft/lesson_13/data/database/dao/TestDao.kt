package ru.profsoft.lesson_13.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.profsoft.lesson_13.data.database.entity.TestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    companion object {
        const val TEST_TABLE = "test"
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(test: TestEntity)

    @Query("select * from $TEST_TABLE")
    fun getTestsFlow(): Flow<List<TestEntity>>
}