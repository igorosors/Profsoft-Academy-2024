package com.example.myapplication.data.repositories

import com.example.myapplication.domiane.models.User
import java.util.Date

class FakeUserRepository():IUserRepository {
    override fun getUser(): User {
        return User(
            id = 1,
            name = "ldflksdm",
            birthDate = Date()
        )
    }
}