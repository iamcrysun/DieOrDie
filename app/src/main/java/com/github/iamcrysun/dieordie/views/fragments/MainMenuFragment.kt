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
        //размещение фрагмента в контейнере статически
        val view = inflater.inflate(R.layout.fragment_main_menu, container, false)
        //ищем меню
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
            //т.к сейчас дейтсвие перехода рассчитано только для одного пункта меня, то навешиваем его по условию
            if (i==0) {
                menuItemView.setOnClickListener {
                    findNavController().navigate(R.id.action_mainMenuFragment_to_doctorAppointmentFragment)
                }
            }

            if (i==1) {
                menuItemView.setOnClickListener {
                    findNavController().navigate(R.id.action_mainMenuFragment_to_doctorsListFragment)
                }
            }

            if (i==2) {
                menuItemView.setOnClickListener {
                    findNavController().navigate(R.id.action_mainMenuFragment_to_historyListFragment)
                }
            }

            if (i==3) {
                menuItemView.setOnClickListener {
                    findNavController().navigate(R.id.action_mainMenuFragment_to_profileFragment)
                }
            }


            //заголовки списков меню
            val header = menuItemView.findViewById<TextView>(R.id.menu_item_header)
            header.text = menuItemsTitles[i]
            //описание пунктов мегю
            val description = menuItemView.findViewById<TextView>(R.id.menu_item_description)
            description.text = menuItemsDescriptions[i]
            //добавляем меню на вьюху
            menuItems.addView(menuItemView)
        }
        // переход от главного меню на стартовую страничку
        view.findViewById<TextView>(R.id.exittext).setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_greetingFragment)
        }

        return view
    }
}