/* (C)2024 - UBB RAIFFEISEN THINK THANK */
package com.ubb.raiffaisen.thinktank.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ubb.raiffaisen.thinktank.common.core.CommonRepository
import com.ubb.raiffaisen.thinktank.common.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    commonRepository: CommonRepository,
) : ViewModel() {
    val userData: LiveData<User?> = commonRepository.getCurrentUserData()
}
