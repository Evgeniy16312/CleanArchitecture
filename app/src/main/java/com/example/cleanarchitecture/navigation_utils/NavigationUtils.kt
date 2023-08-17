package com.example.cleanarchitecture.navigation_utils

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavOptions

fun NavigationManager?.observeNavigation(navController: NavController) {

    fun callNavControllerNavigate(navigationManager: NavigationManager, navOptions: NavOptions) {
        navController.navigate(navigationManager.destinationId!!, navigationManager.bundle, navOptions)
    }

    this?.let { navigationManager ->
        val navOptions = NavOptions.Builder()

        navigationManager.enterAnim?.let { navOptions.setEnterAnim(it) }
        navigationManager.exitAnim?.let { navOptions.setExitAnim(it) }
        navigationManager.popEnterAnim?.let { navOptions.setPopEnterAnim(it) }
        navigationManager.popExitAnim?.let { navOptions.setPopExitAnim(it) }

        if (navigationManager.needPopUp) {
            val popUpSuccessful = navController.popBackStack(navigationManager.destinationId!!, false)

            if (!popUpSuccessful) {
                Log.w(
                    this.javaClass.simpleName,
                    "destinationId не найден в backstack при вызове navController.popBackStack(...), сработал стандартный navigate(...)"
                )
                callNavControllerNavigate(navigationManager, navOptions.build())
            }
        } else {
            callNavControllerNavigate(navigationManager, navOptions.build())
        }
    }
}