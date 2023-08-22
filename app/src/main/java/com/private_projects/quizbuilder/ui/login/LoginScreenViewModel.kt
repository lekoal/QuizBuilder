package com.private_projects.quizbuilder.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.private_projects.quizbuilder.domain.LocalUserData
import com.private_projects.quizbuilder.mock_data.UserData
import com.private_projects.quizbuilder.mock_data.Users
import com.private_projects.quizbuilder.utils.HashCoding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel(context: Context) : ViewModel() {
    private val localUserData = LocalUserData(context = context.applicationContext)
    private val _savedUserData = MutableStateFlow(UserData("", ""))
    private val userList = Users.list
    private val hashCoding = HashCoding()

    val savedUserData: StateFlow<UserData>
        get() = _savedUserData

    private val _userLoginState = MutableStateFlow<LoginState>(LoginState.Initial)
    val userLoginState: StateFlow<LoginState>
        get() = _userLoginState

    fun readFromSP() {
        viewModelScope.launch {
            localUserData.read().let {
                if (it != null) {
                    _savedUserData.emit(it)
                }
            }
        }
    }

    fun checkUserLogin(userData: UserData) {
        val encryptedUserData = UserData(
            userName = userData.userName,
            userPassword = hashCoding.convert(userData.userPassword)
        )
        viewModelScope.launch {
            _userLoginState.emit(LoginState.Login)
            delay(1000)
            if (userList.contains(encryptedUserData)) {
                _userLoginState.emit(LoginState.Success)
                return@launch
            } else {
                _userLoginState.emit(LoginState.Error)
                delay(100)
                _userLoginState.emit(LoginState.Initial)
            }
        }
    }

}