package com.private_projects.quizbuilder.ui.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.private_projects.quizbuilder.R
import com.private_projects.quizbuilder.navigation.ScreenRoutes

@Composable
fun StatisticsScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(text = "Statistics Screen", color = Color.Black)
            OutlinedButton(
                modifier = Modifier.padding(top = 8.dp),
                onClick = {
                    navHostController.navigate(ScreenRoutes.LOGIN_SCREEN_ROUTE)
                },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = stringResource(R.string.login_button_text)
                )
            }
        }
    }
}