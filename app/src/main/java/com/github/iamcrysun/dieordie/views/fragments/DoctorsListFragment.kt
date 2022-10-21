package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader

class DoctorsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_list, container, false)

        val data = readDataFromJSON("data.json")

        return view
    }

    private fun readDataFromJSON(filename: String): List<Doctor> {
        val bufferedReader: BufferedReader =
            requireContext().assets.open(filename).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }

        return Json.decodeFromString(inputString)
    }
}