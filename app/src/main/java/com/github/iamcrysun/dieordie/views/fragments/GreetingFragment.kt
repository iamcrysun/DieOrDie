package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.github.iamcrysun.dieordie.R

class GreetingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_greeting, container, false)

        view.findViewById<Button>(R.id.login_button).setOnClickListener {
            findNavController().navigate(R.id.action_greetingFragment_to_loginFragment)
        }

        view.findViewById<Button>(R.id.registration_button).setOnClickListener {
            findNavController().navigate(R.id.action_greetingFragment_to_registrationFragment)
        }

        return view
    }
}