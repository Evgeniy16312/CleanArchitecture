package com.example.cleanarchitecture.navigation_utils

import android.os.Bundle
import androidx.annotation.AnimRes
import androidx.annotation.IdRes

open class NavigationManager {

    @IdRes
    open val destinationId: Int? = null
    open val bundle: Bundle? = null
    open val needPopUp = false

    @AnimRes
    open val enterAnim: Int? = null
    @AnimRes
    open val popEnterAnim: Int? = null
    @AnimRes
    open val exitAnim: Int? = null
    @AnimRes
    open val popExitAnim: Int? = null
}