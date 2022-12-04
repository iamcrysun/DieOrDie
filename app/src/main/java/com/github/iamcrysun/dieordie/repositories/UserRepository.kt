package com.github.iamcrysun.dieordie.repositories

import androidx.lifecycle.LiveData
import com.github.iamcrysun.dieordie.daos.UserDao
import com.github.iamcrysun.dieordie.models.User


class UserRepository(private val userDao: UserDao) {
    val getAll: LiveData<List<User>> = userDao.getAll()

    fun getByEmail(email: String): User? {
        return userDao.getByEmail(email)
    }

    fun addUser(user: User) {
        userDao.addUser(user)
    }
}