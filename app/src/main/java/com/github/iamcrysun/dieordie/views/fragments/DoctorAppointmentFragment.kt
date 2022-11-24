package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.See
import com.github.iamcrysun.dieordie.viewmodels.SeeViewModel

class DoctorAppointmentFragment : Fragment() {
    private lateinit var seeViewModel: SeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctor_appointment, container, false)

        seeViewModel = ViewModelProvider(this)[SeeViewModel::class.java]

        view.findViewById<Button>(R.id.making_app).setOnClickListener {
            insertSee()
            findNavController().navigate(R.id.action_doctorAppointmentFragment_to_resultFragment)
        }

        return view;
    }



    private fun insertSee() {
        val date = view?.findViewById<EditText>(R.id.datetimeapp)?.text.toString()

        val see = See(0, 1, date, "Еще не прошел")

        seeViewModel.addSee(see)
    }
}