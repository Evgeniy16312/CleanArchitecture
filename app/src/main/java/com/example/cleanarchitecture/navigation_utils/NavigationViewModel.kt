package com.example.cleanarchitecture.navigation_utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigationViewModel: ViewModel() {

    private val _navigationManager: MutableLiveData<NavigationManager?> = MutableLiveData()
    val navigationManager: LiveData<NavigationManager?> = _navigationManager

    var testId = -1

    fun navigateTo(
        navigationManager: NavigationManager
    ) {
        if (navigationManager.destinationId != null) {
            _navigationManager.postValue(navigationManager)
        } else {
            Log.e(
                this.javaClass.simpleName,
                "Необходимо переопределить свойство destinationId у NavigationManager",
                Throwable("Необходимо переопределить свойство destinationId у NavigationManager")
            )
        }
    }
}