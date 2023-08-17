package com.example.domain.repository

import com.example.domain.models.dota.Hero


interface HeroNetworkRepository {
    suspend fun getHeroes(): List<Hero>
}