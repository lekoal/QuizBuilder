package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

const val AUTH_ROUTE = "auth_route"
const val HOME_ROUTE = "home_route"
const val SUBSCRIBES_ROUTE = "subscribes_route"
const val BUILDER_ROUTE = "builder_route"
@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    loginScreenContent: @Composable () -> Unit,
    registrationScreenContent: @Composable () -> Unit,
    forgotPasswordScreenContent: @Composable () -> Unit,
    homeScreenContent: @Composable () -> Unit,
    subscribesScreenContent: @Composable () -> Unit,
    builderScreenContent: @Composable () -> Unit,
    quizScreenContent: @Composable () -> Unit,
    addQuizScreenContent: @Composable () -> Unit,
    gameScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(route = NavigationItem.Home.route) {
            homeScreenContent()
        }

        homeScreenNavGraph(
            homeScreenContent = homeScreenContent,
            subscribesScreenContent = subscribesScreenContent,
            builderScreenContent = builderScreenContent
        )

        authScreenNavGraph(
            loginScreenContent = loginScreenContent,
            registrationScreenContent = registrationScreenContent,
            forgotPasswordScreenContent = forgotPasswordScreenContent
        )

        subscribesScreenNavGraph(
            subscribesScreenContent = subscribesScreenContent,
            quizScreenContent = quizScreenContent,
            gameScreenContent = gameScreenContent
        )

        builderScreenNavGraph(
            builderScreenContent = builderScreenContent,
            addQuizScreenContent = addQuizScreenContent
        )
    }
}