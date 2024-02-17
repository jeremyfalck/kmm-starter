package com.jfalck.kmmstarter.android.presentation

import androidx.lifecycle.ViewModel
import com.jfalck.kmmstarter.domain.usecase.GetGreetingUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GreetingViewModel(
    private val getGreetingUseCase: GetGreetingUseCase,
    private val scope: CoroutineScope
) : ViewModel() {

    private val _greetingStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    val greetingStateFlow: StateFlow<String> get() = _greetingStateFlow

    init {
        scope.launch {
            _greetingStateFlow.value = getGreetingUseCase()
        }
    }

}