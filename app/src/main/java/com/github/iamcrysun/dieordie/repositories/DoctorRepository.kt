package com.github.iamcrysun.dieordie.repositories

import androidx.lifecycle.LiveData
import com.github.iamcrysun.dieordie.daos.DoctorDao
import com.github.iamcrysun.dieordie.models.Doctor

class DoctorRepository(private val doctorDao: DoctorDao) {
    val getAll: LiveData<List<Doctor>> = doctorDao.getAll()

    suspend fun addDoctor(doctor: Doctor) {
        doctorDao.addDoctor(doctor)
    }
}