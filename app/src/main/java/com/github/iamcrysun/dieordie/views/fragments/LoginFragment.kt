package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.github.iamcrysun.dieordie.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<Button>(R.id.back_account_button2).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_greetingFragment)
        }// Inflate the layout for this fragment

        view.findViewById<Button>(R.id.enter_account_button).setOnClickListener {
            if (validateLogForm()) {
                Toast
                    .makeText(
                        requireContext(),
                        "Добро пожаловать!",
                        Toast.LENGTH_LONG
                    )
                    .show()

                findNavController().navigate(R.id.action_loginFragment_to_mainMenuFragment)
            } else
                Toast
                    .makeText(
                        requireContext(),
                        "Неправильный ввод данных",
                        Toast.LENGTH_SHORT
                    )
                    .show()
        }

        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun validateLogForm(): Boolean {
        val emailField = view?.findViewById<TextView>(R.id.email_input_edit_text2)
        val passwordField = view?.findViewById<TextView>(R.id.password_input_edit_text2)

        //TODO: check whitespaces
        return !emailField?.text.isNullOrEmpty() &&
                !passwordField?.text.isNullOrEmpty()
    }
}