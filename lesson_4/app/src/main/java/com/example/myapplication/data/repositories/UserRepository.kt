package com.example.myapplication.data.repositories

import com.example.myapplication.data.api.UserApi
import com.example.myapplication.domiane.models.User

class UserRepository() : IUserRepository {
    override fun getUser(): User {
        val reponse = UserApi().getUser()
        return User(
            id = reponse.id,
            name = reponse.name,
            birthDate = TODO()
        )
    }
}