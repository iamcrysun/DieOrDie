package com.github.iamcrysun.dieordie.views.fragments.doctors_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.viewmodels.DoctorViewModel

class DoctorsListFragment : Fragment() {
    private lateinit var doctorViewModel: DoctorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_list, container, false)

        doctorViewModel = ViewModelProvider(this)[DoctorViewModel::class.java]

        val doctor1 = Doctor(0, "Георгий", "Хирург", "Доктор медицинских наук")
        val doctor2 = Doctor(0, "Анатолий", "Педиатр", "Доктор медицинских наук")

        doctorViewModel.addDoctor(doctor1)
        doctorViewModel.addDoctor(doctor2)

        val data = emptyList<Doctor>()
        val adapter = ListAdapter()
        val doctorsListView = view.findViewById<RecyclerView>(R.id.doctors_list_view)
        doctorsListView.adapter = adapter
        doctorsListView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(data)

        return view
    }
}