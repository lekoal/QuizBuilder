package com.private_projects.quizbuilder.ui.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.private_projects.quizbuilder.R
import com.private_projects.quizbuilder.mock_data.UserData
import com.private_projects.quizbuilder.navigation.NavigationState
import com.private_projects.quizbuilder.navigation.ScreenRoutes
import org.koin.androidx.compose.koinViewModel
import org.koin.core.qualifier.qualifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val viewModel: LoginScreenViewModel =
        koinViewModel(qualifier = qualifier("login_screen_view_model"))
    val userLoginState by viewModel.userLoginState.collectAsState(LoginState.Initial)
    val navigationState = NavigationState(navHostController)
    var userNameText by rememberSaveable {
        mutableStateOf("")
    }
    var userPasswordText by rememberSaveable {
        mutableStateOf("")
    }
    var userPasswordHidden by rememberSaveable {
        mutableStateOf(true)
    }
    when (userLoginState) {
        LoginState.Success -> {
            navigationState.navigateTo(ScreenRoutes.HOME_SCREEN_ROUTE)
        }

        LoginState.Error -> {
            Toast.makeText(context, "Пользователь не найден", Toast.LENGTH_SHORT).show()
        }

        else -> {}
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = stringResource(R.string.login_in_quest_builder_text),
                color = Color.Black,
                modifier = Modifier.padding(top = 200.dp)
            )
            OutlinedTextField(
                value = userNameText,
                onValueChange = { userNameText = it },
                singleLine = true,
                label = { Text(text = stringResource(R.string.enter_user_mail_text)) },
                placeholder = { Text(text = stringResource(R.string.user_mail_placeholder_text)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    autoCorrect = false,
                    imeAction = ImeAction.Done
                )
            )
            OutlinedTextField(
                value = userPasswordText,
                onValueChange = { userPasswordText = it },
                singleLine = true,
                label = { Text(text = stringResource(R.string.enter_user_password_text)) },
                placeholder = { Text(text = stringResource(R.string.user_password_placeholder_text)) },
                visualTransformation =
                if (userPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { userPasswordHidden = !userPasswordHidden }) {
                        val visibilityIcon = if (userPasswordHidden) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff
                        val description =
                            if (userPasswordHidden) stringResource(R.string.show_password_text)
                            else stringResource(
                                R.string.hide_password_text
                            )
                        Icon(
                            imageVector = visibilityIcon,
                            contentDescription = description
                        )
                    }
                }
            )
            OutlinedButton(
                modifier = Modifier.padding(top = 8.dp),
                onClick = {
                    if (userNameText.isNotEmpty() && userPasswordText.isNotEmpty()) {
                        viewModel.checkUserLogin(
                            UserData(
                                userName = userNameText,
                                userPassword = userPasswordText
                            )
                        )
                        focusManager.clearFocus()
                    } else {
                        Toast.makeText(context, "Пустые поля недопустимы", Toast.LENGTH_SHORT)
                            .show()
                        return@OutlinedButton
                    }
                },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = stringResource(R.string.login_button_text)
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                OutlinedButton(
                    modifier = Modifier.padding(bottom = 30.dp),
                    onClick = {
                        navHostController.navigate(ScreenRoutes.REGISTRATION_SCREEN_ROUTE)
                    },
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = stringResource(R.string.registration_button_text)
                    )
                }
            }
        }
    }
    if (userLoginState == LoginState.Login) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.8f))
                .clickable(onClick = {}),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}