package com.private_projects.quizbuilder.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.private_projects.quizbuilder.ui.login.LoginScreen
import com.private_projects.quizbuilder.ui.theme.QuizBuilderTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false) //Возможность отрисовки под системными панелями
        setContent {
            val currentTitle by remember {
                mutableStateOf("Temp title")
            }
            QuizBuilderTheme {
                hideSystemBars(window)
                Box(modifier = Modifier.fillMaxSize()) {
                    Scaffold(
                        topBar = {
                            CommonTopBar(currentTitle)
                        },
                        bottomBar = {
                            CommonBottomBar()
                        },
                        containerColor = MaterialTheme.colorScheme.primary
                    ) { paddingValues ->
                        LoginScreen(paddingValues)
                    }
                }
            }
        }
    }
}

private fun hideSystemBars(window: Window) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowInsetsController = window.insetsController
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsets.Type.systemBars())
            windowInsetsController.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    } else {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )
    }
}