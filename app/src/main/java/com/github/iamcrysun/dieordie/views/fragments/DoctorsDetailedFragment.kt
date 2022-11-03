package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.github.iamcrysun.dieordie.R

class DoctorsDetailedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_detailed, container, false)

        view.findViewById<Button>(R.id.back_to_doctors).setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_doctorsDetailedFragment_to_doctorsListFragment)
        }

        return view
    }
}