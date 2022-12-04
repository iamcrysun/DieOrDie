package com.github.iamcrysun.dieordie.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.iamcrysun.dieordie.DieDB
import com.github.iamcrysun.dieordie.models.User
import com.github.iamcrysun.dieordie.repositories.UserRepository
import com.github.iamcrysun.dieordie.utils.services.AuthorizationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val repository: UserRepository
    private val authorizationService: AuthorizationService
    val getAll: LiveData<List<User>>

    init {
        val userDao = DieDB.Instance(application).userDao()
        repository = UserRepository(userDao)
        authorizationService = AuthorizationService(repository)
        getAll = repository.getAll
    }

    fun signUp(user: User): Boolean {
        return authorizationService.signUp(user)
    }

    fun signIn(user: User): Boolean {
        return authorizationService.signIn(user)
    }
}