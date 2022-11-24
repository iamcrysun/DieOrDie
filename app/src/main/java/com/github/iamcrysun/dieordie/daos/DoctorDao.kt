package com.github.iamcrysun.dieordie.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.iamcrysun.dieordie.models.Doctor

@Dao
interface DoctorDao {
    @Query("SELECT * FROM doctors")
    fun getAll(): LiveData<List<Doctor>>

    @Insert()
    suspend fun addDoctor(doctor: Doctor)
}