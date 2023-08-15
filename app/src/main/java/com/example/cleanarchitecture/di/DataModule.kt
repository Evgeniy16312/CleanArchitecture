package com.example.cleanarchitecture.di

import android.content.Context
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import data.repository.UserRepositoryImpl
import data.storage.UserStorage
import data.storage.sharedprefs.SharedPrefUserStorage

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
}