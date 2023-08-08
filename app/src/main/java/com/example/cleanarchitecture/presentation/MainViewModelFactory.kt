package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetUserNameUseCase
import data.repository.UserRepositoryImpl
import data.storage.sharedprefs.SharedPrefUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(
                context = context
            )
        )
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy {
        com.example.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }

}