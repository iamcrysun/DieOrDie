package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.github.iamcrysun.dieordie.R

class DoctorsDetailedFragment : Fragment() {
    private val args by navArgs<DoctorsDetailedFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_detailed, container, false)

        view.findViewById<TextView>(R.id.docs_name).text = args.doctor.fullName
        view.findViewById<TextView>(R.id.docs_spec).text = args.doctor.specialization
        view.findViewById<TextView>(R.id.docs_info).text = args.doctor.info

        view.findViewById<Button>(R.id.back_to_doctors).setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_doctorsDetailedFragment_to_doctorsListFragment)
        }

        return view
    }
}