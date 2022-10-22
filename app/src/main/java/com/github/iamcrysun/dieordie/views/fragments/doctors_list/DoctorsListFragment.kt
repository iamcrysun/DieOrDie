package com.github.iamcrysun.dieordie.views.fragments.doctors_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString
import kotlinx.serialization.json.JsonNull.serializer
import java.io.BufferedReader

class DoctorsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_list, container, false)

        val data = readDataFromJSON("data.json")

        val adapter = ListAdapter()
        val doctorsListView = view.findViewById<RecyclerView>(R.id.doctors_list_view)
        doctorsListView.adapter = adapter
        doctorsListView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(data)

        return view
    }

    private fun readDataFromJSON(filename: String): List<Doctor> {
        val bufferedReader: BufferedReader =
            requireContext().assets.open(filename).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }

        return decodeFromString<List<Doctor>>(, inputString)
    }
}