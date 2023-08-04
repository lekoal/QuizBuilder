package com.private_projects.quizbuilder.ui.main

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import com.private_projects.quizbuilder.ui.login.LoginScreen
import com.private_projects.quizbuilder.ui.theme.QuizBuilderTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUi(window)
        setContent {
            val currentTitle by remember {
                mutableStateOf("Temp title")
            }
            QuizBuilderTheme {
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

private fun hideSystemUi(window: Window) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.setDecorFitsSystemWindows(false)
        if (window.insetsController != null) {
            window.insetsController!!
                .hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            window.insetsController!!.systemBarsBehavior =
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    } else {
        window.decorView.fitsSystemWindows = false
    }
}