package com.ubb.raiffaisen.thinktank.common.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.common.infra.CommonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CommonModule {

    @Binds
    fun bindCommonRepository(commonRepositoryImpl: CommonRepositoryImpl): CommonRepository

    companion object {

        @Provides
        @Singleton
        fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
    }
}