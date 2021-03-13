/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screen.login.LOGIN_SCREEN_DESTINATION
import java.util.Locale

const val WELCOME_SCREEN_DESTINATION = "welcome"

@Composable
fun WelcomeScreen(navController: NavHostController) {
    WelcomeScreenBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(text = stringResource(id = R.string.get_started).toUpperCase(Locale.ROOT))
                    }
                }
                Spacer(Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    OutlinedButton(
                        onClick = { navController.navigate(LOGIN_SCREEN_DESTINATION) },
                        border = BorderStroke(
                            ButtonDefaults.OutlinedBorderSize, MaterialTheme.colors.primary
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                        modifier = Modifier.fillMaxSize(),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(text = stringResource(id = R.string.log_in).toUpperCase(Locale.ROOT))
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreenBackground(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop
        )
        content()
    }
}
