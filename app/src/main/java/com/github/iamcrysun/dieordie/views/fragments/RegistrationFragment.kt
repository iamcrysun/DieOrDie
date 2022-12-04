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
import com.github.iamcrysun.dieordie.viewmodels.SeeViewModel
import com.github.iamcrysun.dieordie.viewmodels.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RegistrationFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        view.findViewById<FloatingActionButton>(R.id.button_from_log_to_greeting).setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_greetingFragment)
        }

        view.findViewById<Button>(R.id.create_account_button).setOnClickListener {
            if (validateRegistrationForm()) {
                if (signUp()) {
                    Toast
                        .makeText(
                            requireContext(),
                            "Ваш аккаунт успешно создан",
                            Toast.LENGTH_LONG
                        )
                        .show()

                    findNavController().navigate(R.id.action_registrationFragment_to_mainMenuFragment)
                } else
                    Toast
                        .makeText(
                            requireContext(),
                            "Пользователь уже существует",
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

    private fun signUp(): Boolean {
        val emailField = view?.findViewById<TextView>(R.id.email_input_edit_text)
        val passwordField = view?.findViewById<TextView>(R.id.password_input_edit_text)

        val email = emailField?.text.toString()
        val password = passwordField?.text.toString()

        val user = User(0, email, password)

        return userViewModel.signUp(user)
    }

    private fun validateRegistrationForm(): Boolean {
        val emailField = view?.findViewById<TextView>(R.id.email_input_edit_text)
        val passwordField = view?.findViewById<TextView>(R.id.password_input_edit_text)
        val passwordConfirmField =
            view?.findViewById<TextView>(R.id.password_confirm_input_edit_text)

        //TODO: check whitespaces
        return !emailField?.text.isNullOrEmpty() &&
                emailField?.text?.isEmailValid()==true &&
                !passwordField?.text.isNullOrEmpty() &&
                !passwordConfirmField?.text.isNullOrEmpty() &&
                //android.util.Patterns.EMAIL_ADDRESS.matcher().matches() &&
                passwordField?.text.toString() == passwordConfirmField?.text.toString()
    }

    private fun CharSequence.isEmailValid(): Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}