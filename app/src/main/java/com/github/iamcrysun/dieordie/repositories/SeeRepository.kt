package com.github.iamcrysun.dieordie.repositories

import androidx.lifecycle.LiveData
import com.github.iamcrysun.dieordie.daos.DoctorDao
import com.github.iamcrysun.dieordie.daos.SeeDao
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.models.See

class SeeRepository(private val seeDao: SeeDao) {
    val getAll: LiveData<List<See>> = seeDao.getAll()

    suspend fun addSee(see: See) {
        seeDao.addSee(see)
    }
}