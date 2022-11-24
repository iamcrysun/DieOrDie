package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.github.iamcrysun.dieordie.R

class HistoryDetailedFragment : Fragment() {
    private val args by navArgs<HistoryDetailedFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history_detailed, container, false)

        view.findViewById<TextView>(R.id.docs_name1).text = args.historyItem.doctor.toString()
        view.findViewById<TextView>(R.id.history_info).text = args.historyItem.info
        view.findViewById<TextView>(R.id.special).text = args.historyItem.date

        return view
    }
}