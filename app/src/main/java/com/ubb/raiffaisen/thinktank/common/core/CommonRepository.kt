/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.common.core

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseUser
import com.ubb.raiffaisen.thinktank.common.domain.User
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import com.ubb.raiffaisen.thinktank.register.core.RegisterResultCallback
import com.ubb.raiffaisen.thinktank.resetpassword.core.ResetPasswordResultCallback

/** Repository responsible with login and register users. */
interface CommonRepository {
    /** Method used to sign in using email and password */
    fun loginWithEmailAndPassword(
        email: String,
        password: String,
        callback: LoginResultCallback?,
    )

    /** Method used to register in using email and password */
    fun registerWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        callback: RegisterResultCallback?,
    )

    /** Method used to return current user. */
    fun getCurrentUser(): FirebaseUser?

    /** Method used to return current user data. */
    fun getCurrentUserData(): LiveData<User?>

    /** Method used to reset user password. */
    fun resetPassword(
        email: String,
        callback: ResetPasswordResultCallback?,
    )
}
