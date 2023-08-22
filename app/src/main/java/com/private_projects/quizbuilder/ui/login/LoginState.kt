package com.private_projects.quizbuilder.ui.login

sealed class LoginState {
    data object Initial: LoginState()
    data object Login: LoginState()
    data object Success: LoginState()
    data object Error: LoginState()
}
