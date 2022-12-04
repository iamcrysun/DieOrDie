package com.github.iamcrysun.dieordie.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.iamcrysun.dieordie.models.Authorization


@Dao
interface AuthorizationDao {
    @Query("SELECT * FROM authorizations")
    fun getAll(): LiveData<List<Authorization>>

    @Insert()
    suspend fun addAuthorization(authorization: Authorization)
}