package com.github.iamcrysun.dieordie.views.fragments.doctors_list

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.viewmodels.DoctorViewModel
import java.net.URL

class DoctorsListFragment : Fragment() {
    private lateinit var doctorViewModel: DoctorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val view = inflater.inflate(R.layout.fragment_doctors_list, container, false)

        doctorViewModel = ViewModelProvider(this)[DoctorViewModel::class.java]

        val doctor = Doctor(0, "Зубенко Михаил Петрович", "Хирург", "Алкоголик",
        BitmapFactory.decodeStream(URL("https://w7.pngwing.com/pngs/44/624/png-transparent-avatar-people-person-business-user-man-character-set-icon-portrait.png").openStream()))

        doctorViewModel.addDoctor(doctor)

        val adapter = ListAdapter()
        val doctorsListView = view.findViewById<RecyclerView>(R.id.doctors_list_view)
        doctorsListView.adapter = adapter
        doctorsListView.layoutManager = LinearLayoutManager(requireContext())

        doctorViewModel.getAll.observe(viewLifecycleOwner, Observer { doctors ->
            adapter.setData(doctors)
        })

        return view
    }
}