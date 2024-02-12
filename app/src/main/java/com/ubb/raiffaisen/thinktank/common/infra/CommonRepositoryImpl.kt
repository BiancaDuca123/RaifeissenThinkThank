package com.ubb.raiffaisen.thinktank.common.infra

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import com.ubb.raiffaisen.thinktank.register.core.RegisterResultCallback
import com.ubb.raiffaisen.thinktank.resetpassword.core.ResetPasswordResultCallback
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : CommonRepository {

    override fun getCurrentUser(): FirebaseUser? = firebaseAuth.currentUser

    override fun loginWithEmailAndPassword(
        email: String, password: String, callback: LoginResultCallback?
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { login ->
            if (login.isSuccessful) {
                callback?.onLoginSuccess {
                    /* NO-OP */
                }
            } else {
                callback?.onLoginFailure()
            }
        }
    }

    override fun registerWithEmailAndPassword(
        email: String, password: String, callback: RegisterResultCallback?
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { register ->
                if (register.isSuccessful) {
                    callback?.onRegisterSuccess {
                        /* NO-OP */
                    }
                } else {
                    callback?.onRegisterFailure()
                }
            }
    }

    override fun resetPassword(email: String, callback: ResetPasswordResultCallback?) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener { reset ->
                if (reset.isSuccessful) {
                    callback?.onResetPasswordSuccess {
                        /* NO-OP */
                    }
                } else {
                    callback?.onResetPasswordFailure()
                }
            }
    }
}