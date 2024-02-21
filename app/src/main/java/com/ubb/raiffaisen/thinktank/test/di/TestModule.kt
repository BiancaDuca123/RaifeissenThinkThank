package com.ubb.raiffaisen.thinktank.test.di

import com.ubb.raiffaisen.thinktank.test.core.TestRepository
import com.ubb.raiffaisen.thinktank.test.infra.TestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface TestModule {

    // scriem doar o functie care leaga Repository de Repository Implementation
    @Binds
    fun bindTestRepository(testRepositoryImpl: TestRepositoryImpl): TestRepository

}