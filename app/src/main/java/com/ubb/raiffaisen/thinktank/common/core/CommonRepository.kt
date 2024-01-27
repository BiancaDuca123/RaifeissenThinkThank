package com.ubb.raiffaisen.thinktank.common.core

import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback

/** Repository responsible with login and register users. */
interface CommonRepository {

    /** Method used to sign in using email and password */
    fun loginWithEmailAndPassword(email: String, password: String, callback: LoginResultCallback?)

    /** Method used to register in using email and password */
    fun registerWithEmailAndPassword(email: String, password: String)
}