package com.github.iamcrysun.dieordie.views.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.iamcrysun.dieordie.R
import com.github.iamcrysun.dieordie.models.User
import com.github.iamcrysun.dieordie.viewmodels.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        view.findViewById<Button>(R.id.back_account_button2).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_greetingFragment)
        }

        view.findViewById<Button>(R.id.enter_account_button).setOnClickListener {
            if (validateLogForm()) {
                if (signIn()) {
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
                            "Перепроверье логин и пароль",
                            Toast.LENGTH_SHORT
                        )
                        .show()
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

    private fun signIn(): Boolean {
        val emailField = view?.findViewById<TextView>(R.id.email_input_edit_text)
        val passwordField = view?.findViewById<TextView>(R.id.password_input_edit_text)

        val email = emailField?.text.toString()
        val password = passwordField?.text.toString()

        val user = User(0, email, password)

        return userViewModel.signIn(user)
    }

    private fun validateLogForm(): Boolean {
        val emailField = view?.findViewById<TextView>(R.id.email_input_edit_text2)
        val passwordField = view?.findViewById<TextView>(R.id.password_input_edit_text2)

        //TODO: check whitespaces
        return !emailField?.text.isNullOrEmpty() &&
                !passwordField?.text.isNullOrEmpty() &&
                emailField?.text?.isEmailValid() == true
    }

    private fun CharSequence.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this)
            .matches()
    }
}