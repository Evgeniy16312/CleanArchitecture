package com.example.domain.usecase

import com.example.domain.Resource
import com.example.domain.models.dota.Hero
import com.example.domain.repository.HeroNetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

// TODO: add swipe to refresh

class GetHeroesUseCase (val api: HeroNetworkRepository) {
    fun execute(): Flow<Resource<List<Hero>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val remoteHeroes = try {
            val response = api.getHeroes()
            response
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = e.message ?: "Unknown Error"))
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(message = e.message ?: "Unknown Error"))
            null
        }

        remoteHeroes?.let {
            emit(Resource.Success(data = api.getHeroes()))
        }

        emit(Resource.Loading(isLoading = false))
    }
}






























