package com.wzp.recepicapp.presentation.home

import com.wzp.recepicapp.presentation.base.UiEffect
import com.wzp.recepicapp.presentation.base.UiEvent
import com.wzp.recepicapp.presentation.base.UiState

object HomeContract {

    data class State(
        val isLogin : Boolean = false
    ) : UiState

    sealed class Event : UiEvent {

    }

    sealed class Effect : UiEffect {

    }
}