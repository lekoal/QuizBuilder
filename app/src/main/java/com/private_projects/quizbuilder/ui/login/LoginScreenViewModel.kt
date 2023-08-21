package com.private_projects.quizbuilder.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.private_projects.quizbuilder.mock_data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val _isUserLogged = MutableStateFlow(false)
    val isUserLogged: StateFlow<Boolean> = _isUserLogged

    val mockUserData = UserData(
        userName = "admin",
        userPassword = "admin"
    )

    fun checkLoginState() {
        viewModelScope.launch {
            _isUserLogged.emit(true)
        }
    }
}