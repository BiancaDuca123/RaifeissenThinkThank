package com.ubb.raiffaisen.thinktank.resetpassword.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ubb.raiffaisen.thinktank.common.domain.Constants.RESET_PASSWORD_ERROR_MESSAGE
import com.ubb.raiffaisen.thinktank.common.domain.Constants.RESET_PASSWORD_SUCCESS_MESSAGE
import com.ubb.raiffaisen.thinktank.databinding.FragmentResetPasswordBinding
import com.ubb.raiffaisen.thinktank.resetpassword.core.ResetPasswordResultCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment(), ResetPasswordResultCallback {

    private lateinit var binding: FragmentResetPasswordBinding

    private val viewModel: ResetPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setResetPasswordCallBack(this)
        setupUI()
    }

    override fun onResetPasswordSuccess(callback: () -> Unit) {
        findNavController().popBackStack()
        Toast.makeText(context, RESET_PASSWORD_SUCCESS_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    override fun onResetPasswordFailure() {
        Toast.makeText(context, RESET_PASSWORD_ERROR_MESSAGE, Toast.LENGTH_SHORT).show()
    }

    private fun setupUI() = with(binding) {
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        resetPasswordButton.setOnClickListener {
            val email = inputEmail.text.toString()
            if (email.isNotEmpty()) {
                viewModel.resetPassword(email)
            }

        }
    }
}