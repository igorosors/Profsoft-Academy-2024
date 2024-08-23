package ru.profsoft.lesson_13.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.profsoft.lesson_13.data.database.dao.TestDao

@Entity(tableName = TestDao.TEST_TABLE)
class TestEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
)