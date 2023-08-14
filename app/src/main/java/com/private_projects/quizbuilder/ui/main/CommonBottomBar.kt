package com.private_projects.quizbuilder.ui.main

import android.util.Log
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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.private_projects.quizbuilder.navigation.BUILDER_ROUTE
import com.private_projects.quizbuilder.navigation.NavigationItem
import com.private_projects.quizbuilder.navigation.NavigationState
import com.private_projects.quizbuilder.navigation.SUBSCRIBES_ROUTE
import com.private_projects.quizbuilder.utils.ClearRippleTheme

@Composable
fun CommonBottomBar(navHostController: NavHostController) {
    val activity = LocalContext.current as MainActivity
    val onBackPressedDispatcher = activity.onBackPressedDispatcher
    val navigationState = remember {
        NavigationState(navHostController)
    }
    val currentHierarchyRoute = mutableListOf<String>()
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route.toString()
    CompositionLocalProvider(
        LocalRippleTheme provides ClearRippleTheme
    ) {
        if (navBackStackEntry?.destination?.hierarchy?.any {
                it.route == NavigationItem.Login.route
            } == false
        ) {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,
                windowInsets = WindowInsets(0, 0, 0, 0),
            ) {
                val navigationItems = listOf(
                    NavigationItem.Home, NavigationItem.Subscribes, NavigationItem.Builder
                )
                currentHierarchyRoute.clear()
                navigationItems.forEach { navigationItem ->
                    when (navigationItem.route) {
                        SUBSCRIBES_ROUTE, NavigationItem.Subscribes.route -> {
                            currentHierarchyRoute.clear()
                            currentHierarchyRoute.addAll(
                                listOf(
                                    NavigationItem.Subscribes.route,
                                    NavigationItem.Quiz.route,
                                    NavigationItem.Game.route
                                )
                            )
                        }

                        BUILDER_ROUTE, NavigationItem.Builder.route -> {
                            currentHierarchyRoute.clear()
                            currentHierarchyRoute.addAll(
                                listOf(
                                    NavigationItem.Builder.route,
                                    NavigationItem.AddQuiz.route
                                )
                            )
                        }

                        else -> {
                            currentHierarchyRoute.clear()
                            currentHierarchyRoute.add(navigationItem.route)
                        }
                    }
                    currentHierarchyRoute.forEach {
                        Log.i("currentHierarchyRoute", it)
                    }

                    val selected = navBackStackEntry?.destination?.hierarchy?.any {
                        currentHierarchyRoute.contains(it.route)
                    } ?: false

                    val route = navigationItem.route
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                navigationState.navigateTo(route)
                            }
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
}