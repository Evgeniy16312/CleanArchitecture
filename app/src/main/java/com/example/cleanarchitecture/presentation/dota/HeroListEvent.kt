package com.example.cleanarchitecture.presentation.dota

sealed class HeroListEvent {

    data class ShowToast(val message: String) : HeroListEvent()

    data class NavigateToHeroDetailsScreen(val heroId: Int) : HeroListEvent()

    // TODO: add other events
}