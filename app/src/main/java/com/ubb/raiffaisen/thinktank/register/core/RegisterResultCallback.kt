/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.register.core

interface RegisterResultCallback {
    /** Method used to notify a successful register. */
    fun onRegisterSuccess(callback: () -> Unit)

    /** Method used to notify a failed register. */
    fun onRegisterFailure()
}
