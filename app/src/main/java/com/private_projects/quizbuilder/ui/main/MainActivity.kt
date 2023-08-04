package com.private_projects.quizbuilder.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.private_projects.quizbuilder.ui.login.LoginScreen
import com.private_projects.quizbuilder.ui.theme.QuizBuilderTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentTitle by remember {
                mutableStateOf("Temp title")
            }
            QuizBuilderTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        topBar = {
                            CommonTopBar(currentTitle)
                        },
                        bottomBar = {
                            CommonBottomBar()
                        }
                    ) { paddingValues ->
                        LoginScreen(paddingValues)
                    }
                }
            }
        }
    }
}