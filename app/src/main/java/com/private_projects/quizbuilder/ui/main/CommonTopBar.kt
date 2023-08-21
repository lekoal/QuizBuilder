package com.private_projects.quizbuilder.ui.main

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.private_projects.quizbuilder.navigation.NavigationState
import com.private_projects.quizbuilder.ui.menu.CommonTopBarMenu
import com.private_projects.quizbuilder.utils.CurrentRouteScreenTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(navHostController: NavHostController) {
    val navigationState = remember {
        NavigationState(navHostController)
    }
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route.toString()
    val title = CurrentRouteScreenTitle(LocalContext.current)
    TopAppBar(
        windowInsets = WindowInsets(0, 0, 0, 0),
        modifier = Modifier,
        title = {
            Text(
                text = title.getTop(currentRoute),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        actions = {
            IconButton(onClick = { }) {
                CommonTopBarMenu {
                    if (it == "Color") {
                        println("COLOR")
                    } else {
                        navHostController.navigate(it)
                    }
                }
            }
        }
    )
}