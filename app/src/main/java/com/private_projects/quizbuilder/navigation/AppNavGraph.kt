package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    subscribesScreenContent : @Composable () -> Unit,
    builderScreenContent: @Composable () -> Unit
) {
    val homeTitle = NavigationItem.Home.route
    val subscribesTitle = NavigationItem.Subscribes.route
    val builderTitle = NavigationItem.Builder.route
    NavHost(
        navController = navHostController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(route = homeTitle) {
            homeScreenContent()
        }
        composable(route = subscribesTitle) {
            subscribesScreenContent()
        }
        composable(route = builderTitle) {
            builderScreenContent()
        }
    }
}