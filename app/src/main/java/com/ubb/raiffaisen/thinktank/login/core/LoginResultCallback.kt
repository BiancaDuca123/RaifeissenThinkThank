/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.login.core

interface LoginResultCallback {
    /** Method used to notify a successful login. */
    fun onLoginSuccess(callback: () -> Unit)

    /** Method used to notify a failed login. */
    fun onLoginFailure()
}
