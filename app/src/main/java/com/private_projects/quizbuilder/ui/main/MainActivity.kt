package com.private_projects.quizbuilder.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.private_projects.quizbuilder.navigation.AppNavGraph
import com.private_projects.quizbuilder.ui.builder.QuizBuilderScreen
import com.private_projects.quizbuilder.ui.login.LoginScreen
import com.private_projects.quizbuilder.ui.subscribes.SubscribesScreen
import com.private_projects.quizbuilder.ui.theme.QuizBuilderTheme
import com.private_projects.quizbuilder.utils.SystemBarsManagement


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        ) //Возможность отрисовки под системными панелями
        setContent {
            val navHostController = rememberNavController()
            val systemBarsManager = SystemBarsManagement()
            QuizBuilderTheme {

                systemBarsManager.hide(window = window)

                Box(modifier = Modifier.fillMaxSize()) {
                    Scaffold(
                        topBar = {
                            CommonTopBar(navHostController = navHostController)
                        },
                        bottomBar = {
                            CommonBottomBar(navHostController = navHostController)
                        }
                    ) { paddingValues ->
                        AppNavGraph(
                            navHostController = navHostController,
                            homeScreenContent = { LoginScreen(paddingValues = paddingValues) },
                            subscribesScreenContent = { SubscribesScreen(paddingValues = paddingValues) },
                            builderScreenContent = { QuizBuilderScreen(paddingValues = paddingValues) })
                    }
                }
            }
        }
    }
}