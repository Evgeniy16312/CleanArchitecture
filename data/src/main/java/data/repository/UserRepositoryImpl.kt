package data.repository

import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository
import data.storage.models.User
import data.storage.UserStorage



class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain (user: User) : UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage (saveParam: SaveUserNameParam) : User {
        return User(firstName = saveParam.name, lastName = "")
    }
}