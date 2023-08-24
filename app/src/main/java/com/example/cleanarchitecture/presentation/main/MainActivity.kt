package com.example.cleanarchitecture.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.navigation_utils.NavigationViewModel
import com.example.cleanarchitecture.navigation_utils.observeNavigation

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navigationViewModel: NavigationViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        (applicationContext as App).appComponent.inject(this)
        setContentView(view)

        navigationViewModel.navigationManager.observe(this) {
            it.observeNavigation(
                findNavController(R.id.nav_host_fragment_content_main)
            )
        }
    }
}