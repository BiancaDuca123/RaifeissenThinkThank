package com.ubb.raiffaisen.thinktank.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ubb.raiffaisen.thinktank.R
import com.ubb.raiffaisen.thinktank.databinding.FragmentLoginBinding
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginResultCallback {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setLoginResultCallback(this)
        with(binding) {
            loginButton.setOnClickListener {
                loginUser()
            }
        }
    }

    private fun loginUser() = with(binding) {
        viewModel.loginWithEmailAndPassword(email.text.toString(), password.text.toString())
    }

    override fun onLoginSuccess(callback: () -> Unit) {
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        callback.invoke()
    }

    override fun onLoginFailure() {
        Toast.makeText(context, ERROR_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private companion object {
        const val ERROR_MESSAGE = "Login Failed."
    }
}