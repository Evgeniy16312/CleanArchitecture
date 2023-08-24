package com.example.cleanarchitecture.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import data.remote.DotaHeroesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideDotaHeroesApi(): DotaHeroesApi {
        return Retrofit.Builder()
            .baseUrl(DotaHeroesApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(DotaHeroesApi::class.java)
    }
}