package com.ubb.raiffaisen.thinktank.login.infra

import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import javax.inject.Inject

class LoginResultCallbackImpl @Inject constructor() : LoginResultCallback {

    override fun onLoginSuccess(callback: () -> Unit) {}

    override fun onLoginFailure() {}
}