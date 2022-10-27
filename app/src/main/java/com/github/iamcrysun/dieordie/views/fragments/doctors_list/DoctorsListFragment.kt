package com.github.iamcrysun.dieordie.views.fragments.doctors_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.BufferedReader


class DoctorsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctors_list, container, false)
        //список докторов
        val data = readDataFromJSON("data.json")
        //
        val adapter = ListAdapter()
        val doctorsListView = view.findViewById<RecyclerView>(R.id.doctors_list_view)
        doctorsListView.adapter = adapter
        doctorsListView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(data)

        return view
    }

    private fun readDataFromJSON(filename: String): List<Doctor> {
        //экземпляр объекта для работы с
        val gson = Gson()
        //буффер для чтения
        val bufferedReader: BufferedReader =
            requireContext().assets.open(filename).bufferedReader()
        //читает текст в строку
        val inputString = bufferedReader.use { it.readText() }

        return gson.fromJson(inputString, object : TypeToken<ArrayList<Doctor?>?>() {}.type)
    }
}