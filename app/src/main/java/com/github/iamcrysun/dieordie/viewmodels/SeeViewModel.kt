package com.github.iamcrysun.dieordie.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.iamcrysun.dieordie.DieDB
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.models.See
import com.github.iamcrysun.dieordie.repositories.DoctorRepository
import com.github.iamcrysun.dieordie.repositories.SeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeeViewModel(application: Application): AndroidViewModel(application) {
    private val repository: SeeRepository
    private val getAll: LiveData<List<See>>

    init {
        val seeDao = DieDB.Instance(application).seeDao()
        repository = SeeRepository(seeDao)
        getAll = repository.getAll
    }

    fun addSee(see: See) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSee(see)
        }
    }
}