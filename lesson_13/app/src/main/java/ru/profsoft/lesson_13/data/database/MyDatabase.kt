package ru.profsoft.lesson_13.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.profsoft.lesson_13.data.database.dao.TestDao
import ru.profsoft.lesson_13.data.database.entity.TestEntity

@Database(
    entities = [
        TestEntity::class,
    ],
    version = MyDatabase.DATABASE_VERSION
)
abstract class MyDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "database"
    }

    abstract fun testDao(): TestDao
}