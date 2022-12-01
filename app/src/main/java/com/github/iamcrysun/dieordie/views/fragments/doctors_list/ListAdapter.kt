package com.github.iamcrysun.dieordie.views.fragments.doctors_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.views.fragments.DoctorsDetailedFragmentDirections

class ListAdapter : RecyclerView.Adapter<DoctorCardViewHolder>() {
    private var doctorsList = emptyList<Doctor>()
    //строка списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorCardViewHolder {
        return DoctorCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.doctor_card_item, parent, false))
    }
    //дата к списку
    override fun onBindViewHolder(holder: DoctorCardViewHolder, position: Int) {
        val current = doctorsList[position]

        holder.itemView.findViewById<TextView>(R.id.doctor_name).text = current.fullName
        holder.itemView.findViewById<TextView>(R.id.doctor_info).text = current.info
        holder.itemView.findViewById<ImageView>(R.id.photo).setImageBitmap(current.photo)

        holder.itemView.findViewById<ConstraintLayout>(R.id.doctor_card_item).setOnClickListener{
            val action = DoctorsListFragmentDirections.actionDoctorsListFragmentToDoctorsDetailedFragment(current)
            holder.itemView.findNavController().navigate(action)
        }
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