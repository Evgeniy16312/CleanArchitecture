package com.example.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase : GetUserNameUseCase,
    private val saveUserNameUseCase : SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable
    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text : String) {
        val params = com.example.domain.models.SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load()  {
        val userName: com.example.domain.models.UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}