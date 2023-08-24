package com.example.cleanarchitecture.di

import com.example.domain.repository.HeroNetworkRepository
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.GetHeroesUseCase
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideGetHeroesUseCase(heroNetworkRepository: HeroNetworkRepository): GetHeroesUseCase {
        return GetHeroesUseCase(
            api = heroNetworkRepository
        )
    }
}