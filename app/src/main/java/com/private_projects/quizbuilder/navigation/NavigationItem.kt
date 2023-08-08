package com.private_projects.quizbuilder.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmarks
import androidx.compose.material.icons.rounded.Construction
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.private_projects.quizbuilder.R

sealed class NavigationItem(
    val titleId: Int,
    val icon: ImageVector,
    val description: String?
) {
    data object Home: NavigationItem(
        titleId = R.string.main_screen_title,
        icon = Icons.Rounded.Home,
        description = null
    )

    data object Subscribes: NavigationItem(
        titleId = R.string.subscribes_screen_title,
        icon = Icons.Rounded.Bookmarks,
        description = null
    )

    data object Builder: NavigationItem(
        titleId = R.string.builder_screen_title,
        icon = Icons.Rounded.Construction,
        description = null
    )
}
