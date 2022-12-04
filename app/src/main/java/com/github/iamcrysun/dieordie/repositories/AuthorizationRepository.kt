package com.github.iamcrysun.dieordie.repositories

import androidx.lifecycle.LiveData
import com.github.iamcrysun.dieordie.daos.AuthorizationDao
import com.github.iamcrysun.dieordie.models.Authorization


class AuthorizationRepository(private val authorizationDao: AuthorizationDao) {
    val getAll: LiveData<List<Authorization>> = authorizationDao.getAll()

    suspend fun addSee(authorization: Authorization) {
        authorizationDao.addAuthorization(authorization)
    }
}