package com.github.iamcrysun.dieordie.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.iamcrysun.dieordie.models.User


@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE email=:email")
    fun getByEmail(email: String): User?

    @Insert()
    fun addUser(user: User)
}