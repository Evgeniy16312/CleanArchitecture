package com.example.cleanarchitecture.presentation.dota

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import com.example.domain.usecase.GetHeroesUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HeroListViewModel (
    private val getHeroes: GetHeroesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeroListState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<HeroListEvent>()
    val events = _events.asSharedFlow()

    init {
        getHeroes()
    }

    fun onTriggerEvent(event: HeroListEvent) = viewModelScope.launch {
        when (event) {
            is HeroListEvent.ShowToast -> {
                _events.emit(HeroListEvent.ShowToast(message = event.message))
            }
            is HeroListEvent.NavigateToHeroDetailsScreen -> {
                _events.emit(HeroListEvent.NavigateToHeroDetailsScreen(heroId = event.heroId))
            }
        }
    }

    private fun getHeroes() {
        viewModelScope.launch {
            getHeroes.execute()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { heroes ->
                                _uiState.value = uiState.value.copy(heroes = heroes)
                            }
                        }
                        is Resource.Error -> {
                            onTriggerEvent(
                                event = HeroListEvent.ShowToast(
                                    message = result.message ?: "Unknown Error!"
                                )
                            )
                        }
                        is Resource.Loading -> {
                            _uiState.value = uiState.value.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}





























