package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.builderScreenNavGraph(
    builderScreenContent: @Composable () -> Unit,
    addQuizScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = NavigationItem.Builder.route,
        route = BUILDER_ROUTE
    ) {
        composable(route = NavigationItem.Builder.route) {
            builderScreenContent()
        }
        composable(route = NavigationItem.AddQuiz.route) {
            addQuizScreenContent()
        }
    }
}