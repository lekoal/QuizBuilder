package com.private_projects.quizbuilder.utils

import android.content.Context
import com.private_projects.quizbuilder.R
import com.private_projects.quizbuilder.navigation.NavigationItem

class CurrentRouteScreenTitle(context: Context) {

    private val homeScreenTitle = context.getString(R.string.home_screen_top_bar_title)
    private val loginScreenTitle = context.getString(R.string.login_screen_top_bar_title)
    private val subscribesScreenTitle = context.getString(R.string.subscribes_screen_top_bar_title)
    private val builderScreenTitle = context.getString(R.string.builder_screen_top_bar_title)
    private val quizScreenTitle = context.getString(R.string.quiz_screen_top_bar_title)
    private val gameScreenTitle = context.getString(R.string.game_screen_top_bar_title)
    private val addQuizScreenTitle = context.getString(R.string.add_quiz_screen_top_bar_title)
    fun getTop(route: String): String {
        return when (route) {
            NavigationItem.Home.route -> {
                homeScreenTitle
            }
            NavigationItem.Subscribes.route -> {
                subscribesScreenTitle
            }
            NavigationItem.Builder.route -> {
                builderScreenTitle
            }
            NavigationItem.Login.route -> {
                loginScreenTitle
            }
            NavigationItem.Quiz.route -> {
                quizScreenTitle
            }
            NavigationItem.AddQuiz.route -> {
                addQuizScreenTitle
            }
            NavigationItem.Game.route -> {
                gameScreenTitle
            }
            else -> "unidentified"
        }
    }
}