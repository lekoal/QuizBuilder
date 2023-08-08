package com.private_projects.quizbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
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
    val homeTitle = stringResource(id = NavigationItem.Home.titleId)
    val subscribesTitle = stringResource(id = NavigationItem.Subscribes.titleId)
    val builderTitle = stringResource(id = NavigationItem.Builder.titleId)
    NavHost(
        navController = navHostController,
        startDestination = stringResource(id = NavigationItem.Home.titleId)
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