package com.github.iamcrysun.dieordie.views.fragments.doctors_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor

class ListAdapter : RecyclerView.Adapter<DoctorCardViewHolder>() {
    private var doctorsList = emptyList<Doctor>()
    //строка списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorCardViewHolder {
        return DoctorCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.doctor_card, parent, false))
    }
    //дата к списку
    override fun onBindViewHolder(holder: DoctorCardViewHolder, position: Int) {
        var current = doctorsList[position]

        holder.itemView.findViewById<TextView>(R.id.doctor_name).text = current.fullName
        holder.itemView.findViewById<TextView>(R.id.doctor_info).text = current.info
    }
    //
    fun setData(doctors: List<Doctor>) {
        this.doctorsList = doctors
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }
}