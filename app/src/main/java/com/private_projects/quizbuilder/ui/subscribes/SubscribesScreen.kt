package com.private_projects.quizbuilder.ui.subscribes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.private_projects.quizbuilder.navigation.NavigationItem
import com.private_projects.quizbuilder.navigation.NavigationState

@Composable
fun SubscribesScreen(navHostController: NavHostController) {
    val navigationState = remember {
        NavigationState(navHostController)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Subscribes Screen", color = Color.Black)
            OutlinedButton(onClick = { navigationState.navigateTo(NavigationItem.Quiz.route) }) {
                Text(text = "GOTO Quiz Screen")
            }
            OutlinedButton(onClick = { navigationState.navigateTo(NavigationItem.Game.route) }) {
                Text(text = "GOTO Game Screen")
            }
        }
    }
}