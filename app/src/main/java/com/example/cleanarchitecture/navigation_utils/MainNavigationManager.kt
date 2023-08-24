package com.example.cleanarchitecture.navigation_utils

import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.presentation.detail_info_hero.DetailInfoHeroFragmentArgs


sealed class MainNavigationManager : NavigationManager() {

    object HeroisListFragment : MainNavigationManager() {
        override val needPopUp = true
        override val destinationId = R.id.heroisListFragment
    }

    data class DetailInfoHeroFragment(
        val args: DetailInfoHeroFragmentArgs
    ) : MainNavigationManager() {
        override val bundle = args.toBundle()
        override val destinationId = R.id.detailInfoHeroFragment
    }
}