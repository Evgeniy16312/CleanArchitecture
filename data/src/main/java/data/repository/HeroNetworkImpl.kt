package data.repository

import com.example.domain.models.dota.Hero
import com.example.domain.repository.HeroNetworkRepository
import data.model.mapper.toHero
import data.remote.DotaHeroesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class HeroNetworkImpl (
    private val api: DotaHeroesApi
) : HeroNetworkRepository {
    override suspend fun getHeroes(): List<Hero> = withContext(Dispatchers.IO) {
        api.getHeroes().map { it.toHero() }
    }
}




















