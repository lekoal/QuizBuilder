package com.private_projects.quizbuilder.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.private_projects.quizbuilder.navigation.AppNavGraph
import com.private_projects.quizbuilder.navigation.EnterAnimation
import com.private_projects.quizbuilder.ui.add_quiz.AddQuizScreen
import com.private_projects.quizbuilder.ui.builder.QuizBuilderScreen
import com.private_projects.quizbuilder.ui.forgot_password.ForgotPasswordScreen
import com.private_projects.quizbuilder.ui.game.GameScreen
import com.private_projects.quizbuilder.ui.login.LoginScreen
import com.private_projects.quizbuilder.ui.quizzes.QuizScreen
import com.private_projects.quizbuilder.ui.registration.RegistrationScreen
import com.private_projects.quizbuilder.ui.statistics.StatisticsScreen
import com.private_projects.quizbuilder.ui.subscribes.SubscribesScreen

@Composable
fun NavGraphScreens(navHostController: NavHostController, paddingValues: PaddingValues) {
    AppNavGraph(
        navHostController = navHostController,
        homeScreenContent = {
            EnterAnimation {
                StatisticsScreen(
                    navHostController = navHostController
                )
            }
        },
        loginScreenContent = {
            EnterAnimation {
                LoginScreen(navHostController = navHostController)
            }
        },
        subscribesScreenContent = {
            EnterAnimation {
                SubscribesScreen(navHostController = navHostController)
            }
        },
        builderScreenContent = {
            EnterAnimation {
                QuizBuilderScreen(navHostController = navHostController)
            }
        },
        quizScreenContent = {
            EnterAnimation {
                QuizScreen(navHostController = navHostController)
            }
        },
        addQuizScreenContent = {
            EnterAnimation {
                AddQuizScreen(navHostController = navHostController)
            }
        },
        gameScreenContent = {
            EnterAnimation {
                GameScreen(navHostController = navHostController)
            }
        },
        registrationScreenContent = {
            EnterAnimation {
                RegistrationScreen(navHostController = navHostController)
            }
        },
        forgotPasswordScreenContent = {
            EnterAnimation {
                ForgotPasswordScreen(navHostController = navHostController)
            }
        })
}