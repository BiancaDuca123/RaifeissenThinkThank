/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.resetpassword.core

interface ResetPasswordResultCallback {
    /** Method used to notify a successful register. */
    fun onResetPasswordSuccess(callback: () -> Unit)

    /** Method used to notify a failed register. */
    fun onResetPasswordFailure()
}
