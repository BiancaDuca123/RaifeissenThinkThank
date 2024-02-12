package com.ubb.raiffaisen.thinktank.register.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ubb.raiffaisen.thinktank.common.domain.Constants.REGISTER_ERROR_MESSAGE
import com.ubb.raiffaisen.thinktank.common.domain.Constants.REGISTER_SUCCESS_MESSAGE
import com.ubb.raiffaisen.thinktank.databinding.FragmentRegisterBinding
import com.ubb.raiffaisen.thinktank.register.core.RegisterResultCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(), RegisterResultCallback {

    private lateinit var binding: FragmentRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setRegisterResultCallback(this)
        setupUI()
    }

    override fun onRegisterSuccess(callback: () -> Unit) {
        findNavController().popBackStack()
        Toast.makeText(context, REGISTER_SUCCESS_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    override fun onRegisterFailure() {
        Toast.makeText(context, REGISTER_ERROR_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private fun setupUI() = with(binding) {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        createAccountButton.setOnClickListener {
            registerWithEmailAndPassword(
                inputEmail.text.toString(),
                inputPassword.text.toString(),
                inputGender.text.toString(),
                inputName.text.toString()
            )
        }
    }

    private fun registerWithEmailAndPassword(
        email: String, password: String, gender: String, name: String
    ) {
        viewModel.registerWithEmailAndPassword(email, password, gender, name)
    }
}