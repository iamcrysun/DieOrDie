package com.github.iamcrysun.dieordie.utils.services

import android.util.Log
import com.github.iamcrysun.dieordie.models.User
import com.github.iamcrysun.dieordie.repositories.UserRepository

class AuthorizationService(repository: UserRepository) {
    private val userRepository: UserRepository

    init {
        userRepository = repository
    }

    fun signUp(user: User): Boolean {
        val existingUserWithSameEmail = userRepository.getByEmail(user.email)

        if (existingUserWithSameEmail == null) {
            userRepository.addUser(user)
            return true
        }

        return false
    }

    fun signIn(user: User): Boolean {
        val existingUserWithSameEmail = userRepository.getByEmail(user.email)
        Log.d("boo", existingUserWithSameEmail?.email.toString())

        if (existingUserWithSameEmail != null) {
            return true
        }

        return false
    }
}