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
package com.example.androiddevchallenge.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screen.home.HOME_SCREEN_DESTINATION
import com.example.androiddevchallenge.ui.theme.gray900
import java.util.Locale

const val LOGIN_SCREEN_DESTINATION = "login"

@Composable
fun LoginScreen(navController: NavHostController) {
    var emailAddress by mutableStateOf("")
    var password by mutableStateOf("")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = if (isSystemInDarkTheme()) gray900 else Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login_bg),
                    contentDescription = "Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(id = R.string.welcome_back),
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(152.dp),
                    style = MaterialTheme.typography.h2,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(Modifier.height(40.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = emailAddress,
                    onValueChange = { emailAddress = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.email_address),
                            style = MaterialTheme.typography.body1
                        )
                    },
                    singleLine = true,
                    leadingIcon = { Icon(Icons.Default.Email, "Email") }
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = stringResource(id = R.string.email_address),
                            style = MaterialTheme.typography.body1
                        )
                    },
                    singleLine = true,
                    leadingIcon = { Icon(Icons.Default.Password, "Password") }
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(HOME_SCREEN_DESTINATION) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(text = stringResource(id = R.string.log_in).toUpperCase(Locale.ROOT))
                }
            }
        }
    }
}
