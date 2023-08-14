package com.private_projects.quizbuilder.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(navHostController.graph.findStartDestination().id) {//Удаление промежуточных экранов из backStack
                saveState = true //Сохранение состояния удаляемого экрана
            }
            launchSingleTop = true //Запрет на очередное создание открытого экрана
            restoreState = true //Восстановление состояния ранее удалённого экрана
        }
    }
}