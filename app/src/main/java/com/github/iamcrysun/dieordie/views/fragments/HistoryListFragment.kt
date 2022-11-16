package com.github.iamcrysun.dieordie.views.fragments

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
import com.github.iamcrysun.dieordie.models.Sees
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.BufferedReader


class HistoryListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history_list, container, false)
        //список докторов
        val data = readDataFromJSON("sees.json")
        //
        val adapter = ListAdapterSee()
        val seesListView = view.findViewById<RecyclerView>(R.id.sees_list_view)
        seesListView.adapter = adapter
        seesListView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(data)

        return view
    }

    private fun readDataFromJSON(filename: String): List<Sees> {
        //экземпляр объекта для работы с
        val gson = Gson()
        //буффер для чтения
        val bufferedReader: BufferedReader =
            requireContext().assets.open(filename).bufferedReader()
        //читает текст в строку
        val inputString = bufferedReader.use { it.readText() }

        return gson.fromJson(inputString, object : TypeToken<ArrayList<Sees?>?>() {}.type)
    }
}