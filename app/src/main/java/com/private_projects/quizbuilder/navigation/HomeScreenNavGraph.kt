package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeScreenNavGraph(
    homeScreenContent: @Composable () -> Unit,
    subscribesScreenContent: @Composable () -> Unit,
    builderScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = NavigationItem.Home.route,
        route = HOME_ROUTE
    ) {
        composable(route = NavigationItem.Home.route) {
            homeScreenContent()
        }
        composable(route = NavigationItem.Subscribes.route) {
            subscribesScreenContent()
        }
        composable(route = NavigationItem.Builder.route) {
            builderScreenContent()
        }
    }
}