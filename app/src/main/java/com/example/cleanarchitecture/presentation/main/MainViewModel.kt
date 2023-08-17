package com.example.cleanarchitecture.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.presentation.main.LoadEvent
import com.example.cleanarchitecture.presentation.main.MainEvent
import com.example.cleanarchitecture.presentation.main.MainState
import com.example.cleanarchitecture.presentation.main.SaveEvent
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var stateLiveMutable = MutableLiveData<MainState>()
    val stateLive: LiveData<MainState> = stateLiveMutable

    init {
        Log.e("AAA", "VM created")
        stateLiveMutable.value = MainState(
            saveResult = false,
            "",
            ""
        )
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> {
                save(text = event.text)
            }

            is LoadEvent -> {
                load()
            }
        }
    }

    private fun save(text: String) {
        val params = com.example.domain.models.SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        stateLiveMutable.value = MainState(
            saveResult = resultData,
            firstName = stateLiveMutable.value?.firstName ?: "",
            lastName = stateLiveMutable.value?.lastName ?: ""
        )
    }

    private fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        stateLiveMutable.value = MainState(
            saveResult = stateLiveMutable.value?.saveResult ?: false,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }
}