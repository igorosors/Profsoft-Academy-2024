package ru.profsoft.lesson_13.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.profsoft.lesson_13.data.repository.DatabaseRepositoryImpl
import ru.profsoft.lesson_13.domain.repository.DatabaseRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideDatabaseRepository(databaseRepositoryImpl: DatabaseRepositoryImpl): DatabaseRepository
}