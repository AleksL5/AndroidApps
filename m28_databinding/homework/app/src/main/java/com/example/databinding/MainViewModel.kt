package com.example.databinding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val requestString = MutableSharedFlow<String>(replay = 1)
    var foundText: String = "Здесь будет отображаться результат запроса"
    private val _state = MutableStateFlow(State.SEARCH_ON_PAUSE)
    val state = _state.asStateFlow()



    var request = ""
        set(value) {
            field = value
            viewModelScope.coroutineContext.cancelChildren()
            requestString.tryEmit(request)
            if (request.length > 2) find()
            else {
                _state.value = State.SEARCH_ON_PAUSE
                foundText = "Слишком короткий запрос"

            }
        }

    private fun find(){
        requestString.debounce(300).onEach {
            foundText = "Ищем..."
            _state.value = State.SEARCH_IN_PROCESS
            foundText = repository.getData() ?: "По вашему запросу \"$it\" ничего не найдено"
            _state.value = State.SEARCH_ON_FINISH
        }.launchIn(viewModelScope)
    }
}

