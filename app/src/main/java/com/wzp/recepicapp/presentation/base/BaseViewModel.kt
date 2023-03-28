package com.wzp.recepicapp.presentation.base


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface UiEvent
interface UiEffect
interface UiState

abstract class BaseViewModel : ViewModel() {

    private val mUiEvent: MutableSharedFlow<UiEvent> = MutableSharedFlow()
    val event = mUiEvent.asSharedFlow()

    private val mUiEffect: Channel<UiEffect> = Channel()
    val effect = mUiEffect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    fun notifyEvent(event: UiEvent) {
        viewModelScope.launch { mUiEvent.emit(event) }
    }

    fun triggerEffect(effect: () -> UiEffect) {
        viewModelScope.launch { mUiEffect.send(effect()) }
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(it: UiEvent)

}