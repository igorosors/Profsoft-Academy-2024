package com.example.myapplication.data.repositories

import com.example.myapplication.domiane.models.User

interface IUserRepository {
    fun getUser(): User
}