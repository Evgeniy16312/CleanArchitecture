package com.example.cleanarchitecture

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.domain.usecase.GetUserNameUseCase
import data.repository.UserRepositoryImpl
import data.storage.sharedprefs.SharedPrefUserStorage


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userRepository by lazy (LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(
                context = applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy {
        com.example.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSave.setOnClickListener {
            val text = binding.editTv.text.toString()
            val params = com.example.domain.models.SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            binding.textView.text = "Save result = $result"
        }

        binding.buttonGet.setOnClickListener {
            val userName: com.example.domain.models.UserName = getUserNameUseCase.execute()
            binding.textView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}