package com.example.domain.usecase

import com.example.domain.models.main.UserName
import com.example.domain.repository.UserRepository

class GetUserNameUseCase(val userRepository : UserRepository) {
    fun execute() : UserName {
        return userRepository.getName()
    }
}