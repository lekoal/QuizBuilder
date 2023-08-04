package com.private_projects.quizbuilder.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.private_projects.quizbuilder.utils.ClearRippleTheme

@Composable
fun CommonBottomBar() {
    val iconSize = 24.dp
    CompositionLocalProvider(
        LocalRippleTheme provides ClearRippleTheme
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            var selectedItemPosition by remember {
                mutableStateOf(0)
            }
            val navigationItems = listOf(
                NavigationItem.Home, NavigationItem.Subscribes, NavigationItem.Builder
            )
            navigationItems.forEachIndexed { index, navigationItem ->
                NavigationBarItem(
                    modifier = Modifier
                        .background(
                            color = if (selectedItemPosition == index)
                                MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.primary
                        ),
                    selected = selectedItemPosition == index,
                    onClick = { selectedItemPosition = index },
                    icon = {
                        Icon(
                            modifier = Modifier.size(iconSize),
                            imageVector = navigationItem.icon,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(navigationItem.titleId))
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        indicatorColor = if (selectedItemPosition == index)
                            MaterialTheme.colorScheme.onPrimary
                        else MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}