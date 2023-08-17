package com.example.cleanarchitecture.navigation_utils

import com.example.cleanarchitecture.R


sealed class MainNavigationManager : NavigationManager() {

    object HeroisListFragment : MainNavigationManager() {
        override val needPopUp = true
        override val destinationId = R.id.heroisListFragment
    }
}