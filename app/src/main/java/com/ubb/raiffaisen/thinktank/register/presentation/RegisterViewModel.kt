/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.register.presentation

import androidx.lifecycle.ViewModel
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.register.core.RegisterResultCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val commonRepository: CommonRepository
) : ViewModel() {
    private var registerResultCallback: RegisterResultCallback? = null

    fun setRegisterResultCallback(callback: RegisterResultCallback) {
        this.registerResultCallback = callback
    }

    fun registerWithEmailAndPassword(
        email: String,
        password: String,
        gender: String,
        name: String
    ) = commonRepository.registerWithEmailAndPassword(
        email,
        password,
        name,
        registerResultCallback,
    )
}
