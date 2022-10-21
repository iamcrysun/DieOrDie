package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.iamcrysun.dieordie.R

class MainMenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_menu, container, false)

        val menuItems = view.findViewById<LinearLayout>(R.id.menu_items)

        val menuItemsTitles = arrayOf(
            "Запись на прием",
            "Список докторов",
            "Прошедшие приемы",
            "Профиль"
        )

        val menuItemsDescriptions = arrayOf(
            "Вы можете выбрать врача, которого хотите посетить, свободные прием и записаться на него",
            "Список всех докторов поликлиники №11",
            "Все Ваши посещения врача отображены в данном списке",
            "Информация о Вас",
        )

        for (i in 0..3) {
            val menuItemView = inflater.inflate(R.layout.main_menu_item, container, false)
            menuItemView.setOnClickListener {
                findNavController().navigate(R.id.action_mainMenuFragment_to_doctorsListFragment)
            }

            val header = menuItemView.findViewById<TextView>(R.id.menu_item_header)
            header.text = menuItemsTitles[i]

            val description = menuItemView.findViewById<TextView>(R.id.menu_item_description)
            description.text = menuItemsDescriptions[i]

            menuItems.addView(menuItemView)
        }

        return view
    }
}