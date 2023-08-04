package com.private_projects.quizbuilder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.private_projects.quizbuilder.ui.theme.QuizBuilderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val paddingValues = Modifier.padding()
            QuizBuilderTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {

                }
            }
        }
    }
}