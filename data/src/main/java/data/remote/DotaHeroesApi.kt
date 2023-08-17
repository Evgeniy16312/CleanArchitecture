package data.remote

import data.model.HeroDto
import retrofit2.http.GET

interface DotaHeroesApi {

    @GET("api/heroStats")
    suspend fun getHeroes(): List<HeroDto>
    companion object {
        const val BASE_URL = "https://api.opendota.com"
    }
}

























