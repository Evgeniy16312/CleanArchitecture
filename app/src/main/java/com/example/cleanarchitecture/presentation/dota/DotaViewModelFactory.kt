package com.example.cleanarchitecture.presentation.dota

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetHeroesUseCase
import javax.inject.Inject

class DotaViewModelFactory @Inject constructor (
     val getHeroes: GetHeroesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HeroListViewModel(
            getHeroes = getHeroes
        ) as T
    }
}