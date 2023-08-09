package com.private_projects.quizbuilder.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.private_projects.quizbuilder.navigation.NavigationItem
import com.private_projects.quizbuilder.utils.BackPressLabelText
import com.private_projects.quizbuilder.utils.CurrentRouteScreenTitle

@Composable
fun IconWithText(
    navigationItem: NavigationItem?,
    currentRoute: String
) {
    val iconSize = 24.dp
    val backPressLabelText = BackPressLabelText(LocalContext.current)
    val title = CurrentRouteScreenTitle(LocalContext.current)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val currentScreen = when (currentRoute) {
            NavigationItem.Subscribes.route -> {
                1
            }

            NavigationItem.Builder.route -> {
                2
            }

            else -> {
                0
            }
        }
        Icon(
            modifier = Modifier.size(iconSize),
            imageVector = navigationItem?.icon ?: Icons.Rounded.ArrowBack,
            contentDescription = navigationItem?.description
        )
        Text(
            text = if (navigationItem != null) title.getBottom(navigationItem.route)
            else backPressLabelText.get(currentScreen)
        )
    }
}