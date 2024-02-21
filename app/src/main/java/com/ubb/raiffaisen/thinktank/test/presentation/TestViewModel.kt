package com.ubb.raiffaisen.thinktank.test.presentation

import androidx.lifecycle.ViewModel
import com.ubb.raiffaisen.thinktank.test.core.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val testRepository: TestRepository
) : ViewModel() {

    fun multiplication(val1: Int, val2: Int): Int = testRepository.multiplication(val1, val2)

    fun sum(val1: Int, val2: Int): Int = testRepository.sum(val1, val2)
}