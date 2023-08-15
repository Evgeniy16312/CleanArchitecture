package com.example.cleanarchitecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "MainActivity created")

        vm = ViewModelProvider(
            this,
            vmFactory
        )[MainViewModel::class.java]


        vm.stateLive.observe(this) { state ->
            binding.textView.text = "${state.firstName} ${state.lastName} ${state.saveResult}"
        }

        binding.buttonSave.setOnClickListener {
            val text = binding.editTv.text.toString()
            vm.send(SaveEvent(text = text))
        }

        binding.buttonGet.setOnClickListener {
            vm.send(LoadEvent())
        }
    }
}