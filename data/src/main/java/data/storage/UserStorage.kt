package data.storage

import data.storage.models.User

interface UserStorage {
    fun save(user : User) : Boolean

    fun get() : User
}