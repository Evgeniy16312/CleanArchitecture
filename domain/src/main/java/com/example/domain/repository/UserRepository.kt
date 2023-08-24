package com.example.domain.repository

import com.example.domain.models.main.SaveUserNameParam
import com.example.domain.models.main.UserName

interface UserRepository {

    fun saveName (saveParam : SaveUserNameParam) : Boolean

    fun getName() : UserName
}