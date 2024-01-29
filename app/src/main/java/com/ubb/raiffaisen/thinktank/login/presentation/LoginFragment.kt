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
import com.ubb.raiffaisen.thinktank.common.domain.Constants.LOGIN_ERROR_MESSAGE
import com.ubb.raiffaisen.thinktank.databinding.FragmentLoginBinding
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginResultCallback {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        checkIfUserIsLogged()
    }

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
        setupUI()
    }

    override fun onLoginSuccess(callback: () -> Unit) {
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        findNavController().popBackStack()
        callback.invoke()
    }

    override fun onLoginFailure() {
        Toast.makeText(context, LOGIN_ERROR_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private fun setupUI() = with(binding) {
        registerAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        loginButton.setOnClickListener {
            loginUser()
        }
        resetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
    }

    private fun loginUser() = with(binding) {
        viewModel.loginWithEmailAndPassword(email.text.toString(), password.text.toString())
    }

    private fun checkIfUserIsLogged() = if (viewModel.getCurrentUser() != null) {
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
    } else {
        /* NO-OP */
    }
}