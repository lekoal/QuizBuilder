package com.private_projects.quizbuilder.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AppRegistration
import androidx.compose.material.icons.rounded.Bookmarks
import androidx.compose.material.icons.rounded.Construction
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LibraryAdd
import androidx.compose.material.icons.rounded.Login
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.QuestionMark
import androidx.compose.material.icons.rounded.VideogameAsset
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val icon: ImageVector,
    val route: String,
    val description: String?
) {
    data object Home : NavigationItem(
        icon = Icons.Rounded.Home,
        route = ScreenRoutes.HOME_SCREEN_ROUTE,
        description = null
    )

    data object Subscribes : NavigationItem(
        icon = Icons.Rounded.Bookmarks,
        route = ScreenRoutes.SUBSCRIBES_SCREEN_ROUTE,
        description = null
    )

    data object Builder : NavigationItem(
        icon = Icons.Rounded.Construction,
        route = ScreenRoutes.BUILD_SCREEN_ROUTE,
        description = null
    )

    data object Login : NavigationItem(
        icon = Icons.Rounded.Login,
        route = ScreenRoutes.LOGIN_SCREEN_ROUTE,
        description = null
    )

    data object Quiz : NavigationItem(
        icon = Icons.Rounded.QuestionMark,
        route = ScreenRoutes.QUIZ_SCREEN_ROUTE,
        description = null
    )

    data object Game : NavigationItem(
        icon = Icons.Rounded.VideogameAsset,
        route = ScreenRoutes.GAME_SCREEN_ROUTE,
        description = null
    )

    data object AddQuiz : NavigationItem(
        icon = Icons.Rounded.LibraryAdd,
        route = ScreenRoutes.ADD_QUIZ_SCREEN_ROUTE,
        description = null
    )

    data object Registration: NavigationItem(
        icon = Icons.Rounded.AppRegistration,
        route = ScreenRoutes.REGISTRATION_SCREEN_ROUTE,
        description = null
    )

    data object ForgotPassword: NavigationItem(
        icon = Icons.Rounded.Password,
        route = ScreenRoutes.FORGOT_PASSWORD_SCREEN_ROUTE,
        description = null
    )

}
