package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.subscribesScreenNavGraph(
    subscribesScreenContent : @Composable () -> Unit,
    quizScreenContent: @Composable () -> Unit,
    gameScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = NavigationItem.Subscribes.route,
        route = SUBSCRIBES_ROUTE
    ) {
        composable(route = NavigationItem.Subscribes.route) {
            subscribesScreenContent()
        }
        composable(route = NavigationItem.Quiz.route) {
            quizScreenContent()
        }
        composable(route = NavigationItem.Game.route) {
            gameScreenContent()
        }
    }
}