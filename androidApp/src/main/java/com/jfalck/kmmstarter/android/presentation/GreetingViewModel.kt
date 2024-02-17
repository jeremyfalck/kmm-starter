package com.jfalck.kmmstarter.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalck.kmmstarter.domain.usecase.GetGreetingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GreetingViewModel(private val getGreetingUseCase: GetGreetingUseCase) : ViewModel() {

    private val _greetingStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    val greetingStateFlow: StateFlow<String> get() = _greetingStateFlow

    init {
        viewModelScope.launch {
            _greetingStateFlow.value = getGreetingUseCase()
        }
    }

}