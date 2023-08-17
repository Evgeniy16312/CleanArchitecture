package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.presentation.dota.DotaViewModelFactory
import com.example.cleanarchitecture.presentation.main.MainViewModelFactory
import com.example.domain.usecase.GetHeroesUseCase
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }

    @Provides
    fun provideDotaViewModelFactory(
         getHeroes: GetHeroesUseCase
    ): DotaViewModelFactory {
        return DotaViewModelFactory(
            getHeroes = getHeroes
        )
    }
}