package com.private_projects.quizbuilder.ui.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Colorize
import androidx.compose.material.icons.rounded.Login
import androidx.compose.material.icons.rounded.PersonAddAlt1
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.private_projects.quizbuilder.R
import com.private_projects.quizbuilder.navigation.ScreenRoutes

@Composable
fun CommonTopBarMenu(
    content: (route: String) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val iconSize = 24.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(
                modifier = Modifier.size(iconSize),
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                text = {
                    Text(text = stringResource(R.string.top_bar_menu_login_text))
                },
                onClick = {
                    expanded = false
                    content(ScreenRoutes.LOGIN_SCREEN_ROUTE)
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Rounded.Login, contentDescription = null)
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = stringResource(R.string.top_bar_menu_register_text))
                },
                onClick = {
                    expanded = false
                    content(ScreenRoutes.REGISTRATION_SCREEN_ROUTE)
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = Icons.Rounded.PersonAddAlt1,
                        contentDescription = null
                    )
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = stringResource(R.string.top_bar_menu_change_color_text))
                },
                onClick = {
                    expanded = false
                    content("Color")
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = Icons.Rounded.Colorize,
                        contentDescription = null
                    )
                }
            )
        }
    }
}