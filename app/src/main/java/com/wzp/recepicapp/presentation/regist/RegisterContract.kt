package com.wzp.recepicapp.presentation.regist

import com.wzp.recepicapp.presentation.base.UiEffect
import com.wzp.recepicapp.presentation.base.UiEvent
import com.wzp.recepicapp.presentation.base.UiState

object RegisterContract {
    data class State(
        val passwordShow : Boolean = false
    ) : UiState

    sealed class Event : UiEvent {
        data class Register(val name:String, val password:String): UiEvent
    }

    sealed class Effect : UiEffect {
        object PopBackStack : UiEffect
        object ShowError : UiEffect
    }
}