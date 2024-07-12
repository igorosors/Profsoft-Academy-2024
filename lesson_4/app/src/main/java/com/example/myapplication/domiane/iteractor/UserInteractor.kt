package com.example.myapplication.domiane.iteractor

import com.example.myapplication.data.repositories.IUserRepository
import com.example.myapplication.ui.models.UserVo

class UserInteractor(
    private val userRepository: IUserRepository
) : IUserInterctor {
    override fun getUser(): UserVo {
        val response = userRepository.getUser()
        return UserVo(
            name = response.name,
            birthDate = response.birthDate
        )
    }
}