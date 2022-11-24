package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.navigation.findNavController
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.models.Sees
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.FileWriter

class DoctorAppointmentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctor_appointment, container, false)

        view.findViewById<Button>(R.id.making_app).setOnClickListener {
            makingSee()

            view.findNavController()
                .navigate(R.id.action_doctorAppointmentFragment_to_resultFragment)
        }

        view.findViewById<Button>(R.id.app_menu).setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_doctorAppointmentFragment_to_mainMenuFragment)
        }

        return view;
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

    private fun makingSee() {
        val doctors_list = readDataFromJSON("data.json")

        val selectSpec = view?.findViewById<Spinner>(R.id.spinner)?.selectedItem
        val doctorName = view?.findViewById<TextView>(R.id.docname_input_edit_text2)?.text.toString()
        val selectedDate = view?.findViewById<TextView>(R.id.date)?.text.toString()

        var id = -1
        for (doctor in doctors_list)
            if (doctor.specialization == selectSpec && doctor.fullName == doctorName) {
                id = doctor.id;
            }

        var newSee = Sees(id=10, doctor_id = id, date = selectedDate, info = "Приема не было")

        val gson = Gson()
        gson.toJson(newSee, FileWriter("sees.json"))
    }
}