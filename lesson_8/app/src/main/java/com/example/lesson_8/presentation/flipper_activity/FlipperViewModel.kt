package com.example.lesson_8.presentation.flipper_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_8.domain.model.LoadingState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FlipperViewModel : ViewModel() {

    private val _liveData = MutableLiveData<LoadingState<Unit>>()
    val liveData: LiveData<LoadingState<Unit>> = _liveData

    init {
        getData(true)
    }

    fun getData(isThrow: Boolean = false) {
        viewModelScope.launch {
           try {
               _liveData.postValue(LoadingState.Loading())
               delay(1500)

               if (isThrow) throw Exception()
               _liveData.postValue(LoadingState.Success(Unit))
           } catch (e: Exception) {
               _liveData.postValue(LoadingState.Error())
           }
        }
    }
}