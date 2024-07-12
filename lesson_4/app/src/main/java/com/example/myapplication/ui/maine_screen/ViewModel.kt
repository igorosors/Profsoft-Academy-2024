package com.example.myapplication.ui.maine_screen

import com.example.myapplication.data.repositories.FakeUserRepository
import com.example.myapplication.domiane.iteractor.IUserInterctor
import com.example.myapplication.domiane.iteractor.UserInteractor
import com.example.myapplication.ui.models.UserVo
import java.util.Date

class ViewModel(
) {
    private val userInteractor: IUserInterctor =
        UserInteractor(userRepository = FakeUserRepository())
    var user = UserVo(name = "", birthDate = Date())

    fun fetchUser() {
        user = userInteractor.getUser()
    }
}