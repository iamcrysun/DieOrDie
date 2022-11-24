package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.See

class HistoryListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history_list, container, false)
        //список докторов
        val data = emptyList<See>()
        //
        val adapter = ListAdapterSee()
        val seesListView = view.findViewById<RecyclerView>(R.id.sees_list_view)
        seesListView.adapter = adapter
        seesListView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(data)

        return view
    }
}