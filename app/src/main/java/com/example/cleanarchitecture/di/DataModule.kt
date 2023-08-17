package com.example.cleanarchitecture.di

import android.content.Context
import com.example.domain.repository.HeroNetworkRepository
import com.example.domain.repository.UserRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import data.remote.DotaHeroesApi
import data.repository.HeroNetworkImpl
import data.repository.UserRepositoryImpl
import data.storage.UserStorage
import data.storage.sharedprefs.SharedPrefUserStorage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(
            context = context
        )
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

    @Provides
    fun provideHeroNetworkRepository(dotaHeroesApi: DotaHeroesApi): HeroNetworkRepository {
        return HeroNetworkImpl(api = dotaHeroesApi)
    }
}