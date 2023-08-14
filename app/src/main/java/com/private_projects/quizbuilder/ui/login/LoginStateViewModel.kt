package com.private_projects.quizbuilder.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginStateViewModel: ViewModel() {
    private val _isUserLogged = MutableStateFlow(false)
    val isUserLogged: StateFlow<Boolean> = _isUserLogged

    fun checkLoginState() {
        viewModelScope.launch {
            _isUserLogged.emit(true)
        }
    }
}