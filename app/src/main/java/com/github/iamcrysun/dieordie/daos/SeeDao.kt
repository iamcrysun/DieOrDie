package com.github.iamcrysun.dieordie.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.models.See

@Dao
interface SeeDao {
    @Query("SELECT * FROM sees")
    fun getAll(): LiveData<List<See>>

    @Insert()
    suspend fun addSee(see: See)
}