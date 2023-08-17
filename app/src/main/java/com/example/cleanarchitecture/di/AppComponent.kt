package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.presentation.dota.HeroisListFragment
import com.example.cleanarchitecture.presentation.main.MainActivity
import com.example.cleanarchitecture.presentation.main.MainFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class, NetworkModule::class] )
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

    fun inject(heroisListFragment: HeroisListFragment)

}