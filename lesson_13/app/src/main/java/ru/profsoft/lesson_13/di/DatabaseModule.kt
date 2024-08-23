package ru.profsoft.lesson_13.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.profsoft.lesson_13.data.database.MyDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            MyDatabase.DATABASE_NAME
        ).build()
    }
}