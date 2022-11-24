package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.viewmodels.SeeViewModel

class HistoryListFragment : Fragment() {
    private lateinit var seeViewModel: SeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history_list, container, false)

        seeViewModel = ViewModelProvider(this)[SeeViewModel::class.java]

        val adapter = ListAdapterSee()
        val seesListView = view.findViewById<RecyclerView>(R.id.sees_list_view)
        seesListView.adapter = adapter
        seesListView.layoutManager = LinearLayoutManager(requireContext())

        seeViewModel.getAll.observe(viewLifecycleOwner, Observer { sees ->
            adapter.setData(sees)
        })

        return view
    }
}