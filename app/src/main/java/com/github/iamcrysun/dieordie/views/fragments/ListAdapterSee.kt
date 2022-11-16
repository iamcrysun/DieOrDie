package com.github.iamcrysun.dieordie.views.fragments

import android.media.MediaParser.SeekPoint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R

import com.github.iamcrysun.dieordie.models.Sees
import com.github.iamcrysun.dieordie.views.fragments.DoctorsDetailedFragmentDirections

class ListAdapterSee : RecyclerView.Adapter<SeeViewHolder>() {
    private var seesList = emptyList<Sees>()
    //строка списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeeViewHolder {
        return SeeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.doctor_card_item, parent, false))
    }
    //дата к списку
    override fun onBindViewHolder(holder: SeeViewHolder, position: Int) {
        val current = seesList[position]

        holder.itemView.findViewById<TextView>(R.id.date_of_see).text = current.date
        holder.itemView.findViewById<TextView>(R.id.doctor_name1).text = current.info

        /*holder.itemView.findViewById<ConstraintLayout>(R.id.doctor_card_item).setOnClickListener{
            val action = HistoryListFragmentDirections.actionDoctorsListFragmentToDoctorsDetailedFragment(current)
            holder.itemView.findNavController().navigate(action)
        }*/
    }
    //
    fun setData(sees: List<Sees>) {
        this.seesList = sees
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return seesList.size
    }
}