package com.github.iamcrysun.dieordie.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.iamcrysun.dieordie.DieDB
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.repositories.DoctorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DoctorViewModel(application: Application): AndroidViewModel(application) {
    private val repository: DoctorRepository
    val getAll: LiveData<List<Doctor>>

    init {
        val doctorDao = DieDB.Instance(application).doctorDao()
        repository = DoctorRepository(doctorDao)
        getAll = repository.getAll
    }

    fun addDoctor(doctor: Doctor) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDoctor(doctor)
        }
    }
}