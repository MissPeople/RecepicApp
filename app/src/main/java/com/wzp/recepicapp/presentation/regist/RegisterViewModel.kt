package com.wzp.recepicapp.presentation.regist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wzp.recepicapp.data.repositories.UserInfoRepository
import com.wzp.recepicapp.domain.model.UserInfoModule
import com.wzp.recepicapp.presentation.base.BaseViewModel
import com.wzp.recepicapp.presentation.base.UiEffect
import com.wzp.recepicapp.presentation.base.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userInfoRepository: UserInfoRepository
): BaseViewModel() {

    private val mState = MutableStateFlow(
        RegisterContract.State(
            false
        )
    )

    init {
        initData()
    }

    private fun initData() {
        viewModelScope.launch {
            mState.value = mState.value.copy(passwordShow = true)
        }
    }

    override fun handleEvent(it: UiEvent) {
        if (it is RegisterContract.Event.Register) {
            viewModelScope.launch {
                userInfoRepository.saveUserInfo(UserInfoModule(it.name, it.password))
                triggerEffect { RegisterContract.Effect.PopBackStack }
            }
        }
    }

}