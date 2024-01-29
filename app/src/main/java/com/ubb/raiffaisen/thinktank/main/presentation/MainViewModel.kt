package com.ubb.raiffaisen.thinktank.main.presentation

import androidx.lifecycle.ViewModel
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val commonRepository: CommonRepository
): ViewModel() {

}