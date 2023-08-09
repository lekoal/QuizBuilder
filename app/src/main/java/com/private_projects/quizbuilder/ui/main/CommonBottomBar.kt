package com.private_projects.quizbuilder.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.private_projects.quizbuilder.navigation.NavigationItem
import com.private_projects.quizbuilder.navigation.NavigationState
import com.private_projects.quizbuilder.utils.ClearRippleTheme

@Composable
fun CommonBottomBar(navHostController: NavHostController) {
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
                val route = navigationItem.route
                NavigationBarItem(
                    selected = currentRoute == route,
                    onClick = {
                        navigationState.navigateTo(route)
                    },
                    icon = {
                        IconWithText(
                            navigationItem = navigationItem,
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
                        navigationItem = null,
                        currentRoute = currentRoute
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