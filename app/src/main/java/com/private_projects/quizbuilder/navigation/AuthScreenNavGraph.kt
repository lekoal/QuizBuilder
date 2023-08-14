package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authScreenNavGraph(
    loginScreenContent: @Composable () -> Unit,
    registrationScreenContent: @Composable () -> Unit,
    forgotPasswordScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = NavigationItem.Login.route,
        route = AUTH_ROUTE
    ) {
        composable(route = NavigationItem.Login.route) {
            loginScreenContent()
        }
        composable(route = NavigationItem.Registration.route) {
            registrationScreenContent()
        }
        composable(route = NavigationItem.ForgotPassword.route) {
            forgotPasswordScreenContent()
        }
    }
}