package com.ubb.raiffaisen.thinktank.common.infra

import com.google.firebase.auth.FirebaseAuth
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : CommonRepository {

    override fun loginWithEmailAndPassword(
        email: String,
        password: String,
        callback: LoginResultCallback?
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { login ->
                if (login.isSuccessful) {
                    callback?.onLoginSuccess {
                        /* NO-OP */
                    }
                } else {
                    callback?.onLoginFailure()
                }
            }
    }

    override fun registerWithEmailAndPassword(email: String, password: String) {
        TODO("Not yet implemented")
    }
}