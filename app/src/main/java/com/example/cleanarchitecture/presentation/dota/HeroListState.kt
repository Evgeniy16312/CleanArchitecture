package com.example.cleanarchitecture.presentation.dota

import com.example.domain.models.dota.Hero

data class HeroListState(
    val heroes: List<Hero> = emptyList(),
    val isLoading: Boolean = false
)

























