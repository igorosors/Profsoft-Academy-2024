package com.example.myapplication.ui.maine_screen

class Fragment {
    private val viewModel: ViewModel()

    fun onCreate(){
        viewModel.fetchUser()
        println(viewModel.user)
    }
}