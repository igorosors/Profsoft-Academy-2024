package com.example.myapplication.data.api

import com.example.myapplication.data.models.UserDTO

class UserApi {
    fun getUser(): UserDTO {
        return UserDTO(
            id = 0,
            name = "Roma",
            birthDate = "2010.12.10 20:00:00"
        )
    }
}