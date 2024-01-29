package com.ubb.raiffaisen.thinktank.resetpassword.presentation

import androidx.lifecycle.ViewModel
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.register.core.RegisterResultCallback
import com.ubb.raiffaisen.thinktank.resetpassword.core.ResetPasswordResultCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(
    private val commonRepository: CommonRepository
) : ViewModel() {

    private var resetPasswordResultCallback: ResetPasswordResultCallback? = null

    fun setResetPasswordCallBack(callback: ResetPasswordResultCallback) {
        this.resetPasswordResultCallback = callback
    }

    fun resetPassword(email: String) =
        commonRepository.resetPassword(email, resetPasswordResultCallback)
}