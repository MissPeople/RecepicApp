package com.wzp.recepicapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wzp.recepicapp.domain.usecase.GetUserIsLoginUseCase
import com.wzp.recepicapp.presentation.base.BaseViewModel
import com.wzp.recepicapp.presentation.base.UiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val userIsLogin: GetUserIsLoginUseCase
): BaseViewModel() {

    private val mState = MutableStateFlow(HomeContract.State())
    val state = mState.asStateFlow()

    init {
        viewModelScope.launch {
            userIsLogin().let {
                mState.value = mState.value.copy(isLogin = it)
            }
        }
    }

    override fun handleEvent(it: UiEvent) {

    }
}