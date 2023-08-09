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
        private const val HOME_SCREEN_ROUTE = "Главная"
        private const val SUBSCRIBES_SCREEN_ROUTE = "Подписки"
        private const val BUILD_SCREEN_ROUTE = "Создать"
        private const val LOGIN_SCREEN_ROUTE = "Вход/регистрация"
        private const val QUIZ_SCREEN_ROUTE = "Информация"
        private const val GAME_SCREEN_ROUTE = "Игра"
        private const val ADD_QUIZ_SCREEN_ROUTE = "Создание квиза"
    }
}
