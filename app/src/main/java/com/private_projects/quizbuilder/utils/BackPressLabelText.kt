package com.private_projects.quizbuilder.utils

import android.content.Context
import com.private_projects.quizbuilder.R

class BackPressLabelText(private val context: Context) {
    fun get(currentScreen: Int): String {
        return when (currentScreen) {
            0 -> context.getString(R.string.back_press_bottom_bar_exit_title)
            else -> context.getString(R.string.back_press_bottom_bar_title)
        }
    }
}