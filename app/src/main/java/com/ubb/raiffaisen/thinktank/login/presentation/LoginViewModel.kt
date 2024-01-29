package com.ubb.raiffaisen.thinktank.login.presentation

import androidx.lifecycle.ViewModel
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val commonRepository: CommonRepository
) : ViewModel() {

    private var loginResultCallback: LoginResultCallback? = null

    fun setLoginResultCallback(callback: LoginResultCallback) {
        this.loginResultCallback = callback
    }

    fun loginWithEmailAndPassword(email: String, password: String) =
        commonRepository.loginWithEmailAndPassword(email, password, loginResultCallback)

    fun getCurrentUser() = commonRepository.getCurrentUser()
}