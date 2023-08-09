package com.private_projects.quizbuilder.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmarks
import androidx.compose.material.icons.rounded.Construction
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LibraryAdd
import androidx.compose.material.icons.rounded.Login
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
        route = HOME_SCREEN_ROUTE,
        description = null
    )

    data object Subscribes : NavigationItem(
        icon = Icons.Rounded.Bookmarks,
        route = SUBSCRIBES_SCREEN_ROUTE,
        description = null
    )

    data object Builder : NavigationItem(
        icon = Icons.Rounded.Construction,
        route = BUILD_SCREEN_ROUTE,
        description = null
    )

    data object Login : NavigationItem(
        icon = Icons.Rounded.Login,
        route = LOGIN_SCREEN_ROUTE,
        description = null
    )

    data object Quiz : NavigationItem(
        icon = Icons.Rounded.QuestionMark,
        route = QUIZ_SCREEN_ROUTE,
        description = null
    )

    data object Game : NavigationItem(
        icon = Icons.Rounded.VideogameAsset,
        route = GAME_SCREEN_ROUTE,
        description = null
    )

    data object AddQuiz : NavigationItem(
        icon = Icons.Rounded.LibraryAdd,
        route = ADD_QUIZ_SCREEN_ROUTE,
        description = null
    )

    private companion object {
        private const val HOME_SCREEN_ROUTE = "home_screen_route"
        private const val SUBSCRIBES_SCREEN_ROUTE = "subscribes_screen_route"
        private const val BUILD_SCREEN_ROUTE = "build_screen_route"
        private const val LOGIN_SCREEN_ROUTE = "login_screen_route"
        private const val QUIZ_SCREEN_ROUTE = "quiz_screen_route"
        private const val GAME_SCREEN_ROUTE = "game_screen_route"
        private const val ADD_QUIZ_SCREEN_ROUTE = "add_quiz_screen_route"
    }
}
