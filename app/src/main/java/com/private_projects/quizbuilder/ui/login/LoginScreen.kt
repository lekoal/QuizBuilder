package com.private_projects.quizbuilder.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.private_projects.quizbuilder.navigation.HOME_ROUTE

@Composable
fun LoginScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Login Screen", color = Color.Black)
            OutlinedButton(onClick = {
                navHostController.navigate(HOME_ROUTE)
            }) {
                Text(text = "GOTO Home")
            }
        }

    }

}