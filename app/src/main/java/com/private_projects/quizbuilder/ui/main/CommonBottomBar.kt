package com.private_projects.quizbuilder.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.private_projects.quizbuilder.R
import com.private_projects.quizbuilder.navigation.NavigationItem
import com.private_projects.quizbuilder.navigation.NavigationState
import com.private_projects.quizbuilder.utils.ClearRippleTheme

@Composable
fun CommonBottomBar(navHostController: NavHostController) {
    val iconSize = 24.dp
    val activity = LocalContext.current as MainActivity
    val onBackPressedDispatcher = activity.onBackPressedDispatcher
    val navigationState = remember {
        NavigationState(navHostController)
    }
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route.toString()
    CompositionLocalProvider(
        LocalRippleTheme provides ClearRippleTheme
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primary,
            windowInsets = WindowInsets(0, 0, 0, 0),
        ) {
            val navigationItems = listOf(
                NavigationItem.Home, NavigationItem.Subscribes, NavigationItem.Builder
            )
            navigationItems.forEach { navigationItem ->
                val route = stringResource(id = navigationItem.titleId)
                NavigationBarItem(
                    selected = currentRoute == route,
                    onClick = {
                        navigationState.navigateTo(route)
                    },
                    icon = {
                        IconWithText(
                            imageVector = navigationItem.icon,
                            contentDescription = navigationItem.description,
                            textId = navigationItem.titleId,
                            iconSize = iconSize,
                            currentRoute = currentRoute
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Cyan,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        indicatorColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
            NavigationBarItem(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary),
                selected = false,
                onClick = {
                    onBackPressedDispatcher.onBackPressed()
                },
                icon = {
                    IconWithText(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = null,
                        iconSize = iconSize,
                        currentRoute = currentRoute,
                        backPressMark = true
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

private fun getBackLabelId(currentScreen: Int): Int {
    return when (currentScreen) {
        0 -> R.string.back_press_exit_title
        else -> R.string.back_press_title
    }
}

@Composable
private fun IconWithText(
    imageVector: ImageVector,
    contentDescription: String?,
    textId: Int? = 0,
    iconSize: Dp,
    backPressMark: Boolean = false,
    currentRoute: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val currentScreen = when (currentRoute) {
            stringResource(id = NavigationItem.Subscribes.titleId) -> { 1 }
            stringResource(id = NavigationItem.Builder.titleId) -> { 2 }
            else -> { 0 }
        }
        Icon(
            modifier = Modifier.size(iconSize),
            imageVector = imageVector,
            contentDescription = contentDescription
        )
        Text(
            text = if (backPressMark) stringResource(id = getBackLabelId(currentScreen))
            else stringResource(id = textId ?: 0)
        )
    }
}