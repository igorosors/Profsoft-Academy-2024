package com.example.lesson_8.domain.model

sealed class LoadingState<T> {
    class Loading<T> : LoadingState<T>()
    class Success<T>(val data: T) : LoadingState<T>()
    class Error<T>() : LoadingState<T>()
}