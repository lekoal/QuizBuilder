package com.private_projects.quizbuilder.utils

import android.content.Context
import com.private_projects.quizbuilder.R
import com.private_projects.quizbuilder.navigation.NavigationItem

class CurrentRouteScreenTitle(context: Context) {

    private val homeScreenTopTitle = context.getString(R.string.home_screen_top_bar_title)
    private val loginScreenTopTitle = context.getString(R.string.login_screen_top_bar_title)
    private val subscribesScreenTopTitle = context.getString(R.string.subscribes_screen_top_bar_title)
    private val builderScreenTopTitle = context.getString(R.string.builder_screen_top_bar_title)
    private val quizScreenTopTitle = context.getString(R.string.quiz_screen_top_bar_title)
    private val gameScreenTopTitle = context.getString(R.string.game_screen_top_bar_title)
    private val addQuizScreenTopTitle = context.getString(R.string.add_quiz_screen_top_bar_title)

    private val homeScreenBottomTitle = context.getString(R.string.home_screen_bottom_bar_title)
    private val loginScreenBottomTitle = context.getString(R.string.login_screen_bottom_bar_title)
    private val subscribesScreenBottomTitle = context.getString(R.string.subscribes_screen_bottom_bar_title)
    private val builderScreenBottomTitle = context.getString(R.string.builder_screen_bottom_bar_title)
    private val quizScreenBottomTitle = context.getString(R.string.quiz_screen_bottom_bar_title)
    private val gameScreenBottomTitle = context.getString(R.string.game_screen_bottom_bar_title)
    private val addQuizScreenBottomTitle = context.getString(R.string.add_quiz_screen_bottom_bar_title)

    fun getTop(route: String): String {
        return when (route) {
            NavigationItem.Home.route -> {
                homeScreenTopTitle
            }
            NavigationItem.Subscribes.route -> {
                subscribesScreenTopTitle
            }
            NavigationItem.Builder.route -> {
                builderScreenTopTitle
            }
            NavigationItem.Login.route -> {
                loginScreenTopTitle
            }
            NavigationItem.Quiz.route -> {
                quizScreenTopTitle
            }
            NavigationItem.AddQuiz.route -> {
                addQuizScreenTopTitle
            }
            NavigationItem.Game.route -> {
                gameScreenTopTitle
            }
            else -> "unidentified"
        }
    }

    fun getBottom(route: String): String {
        return when (route) {
            NavigationItem.Home.route -> {
                homeScreenBottomTitle
            }
            NavigationItem.Subscribes.route -> {
                subscribesScreenBottomTitle
            }
            NavigationItem.Builder.route -> {
                builderScreenBottomTitle
            }
            NavigationItem.Login.route -> {
                loginScreenBottomTitle
            }
            NavigationItem.Quiz.route -> {
                quizScreenBottomTitle
            }
            NavigationItem.AddQuiz.route -> {
                addQuizScreenBottomTitle
            }
            NavigationItem.Game.route -> {
                gameScreenBottomTitle
            }
            else -> "unidentified"
        }
    }
}