package com.example.cleanarchitecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        vm = ViewModelProvider(
            this,
            MainViewModelFactory(this)
        )[MainViewModel::class.java]

        Log.e("AAA", "MainActivity created")

       vm.resultLive.observe(this) {
           binding.textView.text = it
       }

        binding.buttonSave.setOnClickListener {
            val text = binding.editTv.text.toString()
            vm.save(text).toString()
        }

        binding.buttonGet.setOnClickListener {
             vm.load()
        }
    }
}