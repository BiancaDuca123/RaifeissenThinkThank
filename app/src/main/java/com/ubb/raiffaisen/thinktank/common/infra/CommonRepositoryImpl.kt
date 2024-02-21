/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.common.infra

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.common.domain.User
import com.ubb.raiffaisen.thinktank.login.core.LoginResultCallback
import com.ubb.raiffaisen.thinktank.register.core.RegisterResultCallback
import com.ubb.raiffaisen.thinktank.resetpassword.core.ResetPasswordResultCallback
import javax.inject.Inject

class CommonRepositoryImpl
    @Inject
    constructor(
        private val firebaseAuth: FirebaseAuth,
        private val databaseReference: FirebaseFirestore,
    ) : CommonRepository {
        override fun getCurrentUser(): FirebaseUser? = firebaseAuth.currentUser

        override fun loginWithEmailAndPassword(
            email: String,
            password: String,
            callback: LoginResultCallback?,
        ) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { login ->
                    if (login.isSuccessful) {
                        callback?.onLoginSuccess {
                            // NO-OP
                        }
                    } else {
                        callback?.onLoginFailure()
                    }
                }
        }

        override fun registerWithEmailAndPassword(
            email: String,
            password: String,
            name: String,
            callback: RegisterResultCallback?,
        ) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { register ->
                    if (register.isSuccessful) {
                        getCurrentUser()?.let {
                            val userInfo = User(name, DEFAULT_SOLD)
                            databaseReference
                                .collection("users")
                                .document(it.uid)
                                .set(userInfo)
                        }

                        callback?.onRegisterSuccess {

                        }
                    } else {
                        callback?.onRegisterFailure()
                    }
                }
        }

        override fun getCurrentUserData(): LiveData<User?> {
            val currentUser = getCurrentUser()
            val userData = MutableLiveData<User?>()

            currentUser?.let { user ->
                val docRef = databaseReference.collection("users").document(user.uid)
                docRef.addSnapshotListener { snapshot, exception ->
                    if (exception != null) {
                        userData.value = User("ERROR", 0)
                        return@addSnapshotListener
                    }

                    if (snapshot != null && snapshot.exists()) {
                        val userInfo = snapshot.toObject(User::class.java)
                        userData.value = userInfo
                    } else {
                        userData.value = null
                    }
                }
            } ?: run {
                userData.value = null
            }

            return userData
        }

        override fun resetPassword(
            email: String,
            callback: ResetPasswordResultCallback?,
        ) {
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { reset ->
                    if (reset.isSuccessful) {
                        callback?.onResetPasswordSuccess {
                            // NO-OP
                        }
                    } else {
                        callback?.onResetPasswordFailure()
                    }
                }
        }

        private companion object {
            const val DEFAULT_SOLD = 1000
        }
    }
