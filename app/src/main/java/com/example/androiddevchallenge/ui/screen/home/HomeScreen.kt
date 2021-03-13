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
package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.green
import java.util.*

const val HOME_SCREEN_DESTINATION = "home"

@Composable
fun HomeScreen() {
    val chipList = listOf(
        stringResource(id = R.string.week) to true,
        stringResource(id = R.string.etfs) to false,
        stringResource(id = R.string.stock) to false,
        stringResource(id = R.string.funds) to false,
        stringResource(id = R.string.cryptos) to false
    )

    val positionList = listOf(
        Position(
            price = "$7.918",
            isNegative = true,
            percent = 0.54f,
            symbol = "ALK",
            name = "Alaska Air Group, Inc.",
            graph = painterResource(id = R.drawable.home_alk)
        ),
        Position(
            price = "$1,293",
            isNegative = false,
            percent = 4.18f,
            symbol = "BA",
            name = "Boeing Co.",
            graph = painterResource(id = R.drawable.home_ba)
        ),
        Position(
            price = "$893.50",
            isNegative = true,
            percent = 0.54f,
            symbol = "DAL",
            name = "Delta Airlines Inc.",
            graph = painterResource(id = R.drawable.home_dal)
        ),
        Position(
            price = "$12,301",
            isNegative = false,
            percent = 2.51f,
            symbol = "EXPE",
            name = "Expedia Group Inc.",
            graph = painterResource(id = R.drawable.home_exp)
        ),
        Position(
            price = "$12,301",
            isNegative = false,
            percent = 1.38f,
            symbol = "EADSY",
            name = "Airbus SE",
            graph = painterResource(id = R.drawable.home_eadsy)
        ),
        Position(
            price = "$8,521",
            isNegative = false,
            percent = 1.56f,
            symbol = "JBLU",
            name = "Jetblue Airways Corp.",
            graph = painterResource(id = R.drawable.home_jblu)
        ),
        Position(
            price = "$521",
            isNegative = false,
            percent = 2.75f,
            symbol = "MAR",
            name = "Marriot Interantional Inc.",
            graph = painterResource(id = R.drawable.home_mar)
        ),
        Position(
            price = "$5,481",
            isNegative = false,
            percent = 0.14f,
            symbol = "CCL",
            name = "Carnival Corp",
            graph = painterResource(id = R.drawable.home_ccl)
        ),
        Position(
            price = "$9,184",
            isNegative = false,
            percent = 1.69f,
            symbol = "RCL",
            name = "Royal Caribbean Cruises",
            graph = painterResource(id = R.drawable.home_rcl)
        ),
        Position(
            price = "$654",
            isNegative = false,
            percent = 3.23f,
            symbol = "TRVL",
            name = "Travelocity Inc.",
            graph = painterResource(id = R.drawable.home_trvl)
        )
    )

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .paddingFromBaseline(top = 64.dp),
                    ) {
                        Row {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = stringResource(id = R.string.account).toUpperCase(Locale.ROOT),
                                style = MaterialTheme.typography.button,
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = stringResource(id = R.string.watchlist).toUpperCase(Locale.ROOT),
                                style = MaterialTheme.typography.button,
                                textAlign = TextAlign.Center,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = stringResource(id = R.string.profile).toUpperCase(Locale.ROOT),
                                style = MaterialTheme.typography.button,
                                textAlign = TextAlign.Center,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                                text = stringResource(id = R.string.balance),
                                style = MaterialTheme.typography.subtitle1,
                                color = Color.White
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.paddingFromBaseline(top = 48.dp),
                                text = "$73,589.01",
                                style = MaterialTheme.typography.h1,
                                color = Color.White
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.paddingFromBaseline(top = 16.dp),
                                text = stringResource(id = R.string.balance_today, "+412.35"),
                                style = MaterialTheme.typography.subtitle1,
                                color = green
                            )
                            Spacer(Modifier.height(32.dp))
                            Button(
                                onClick = { /* TODO */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(24.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.transact).toUpperCase(
                                        Locale.ROOT
                                    )
                                )
                            }
                            Spacer(Modifier.height(16.dp))
                        }
                        ChipList(items = chipList)
                        Spacer(Modifier.height(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.home_illos),
                            contentDescription = "Graph",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(32.dp))
                    }
                }
                Text(
                    modifier = Modifier.paddingFromBaseline(top = 40.dp),
                    text = stringResource(id = R.string.positions),
                    style = MaterialTheme.typography.subtitle1
                )
            }
            itemsIndexed(positionList) { index, item ->
                PositionItem(item = item, modifier = Modifier.padding(horizontal = 16.dp))
                if (index < positionList.size - 1) {
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}
