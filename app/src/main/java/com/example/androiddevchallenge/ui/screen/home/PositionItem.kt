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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun PositionItem(item: Position, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = item.price, style = MaterialTheme.typography.body1)
                Text(
                    text = "${"-".takeIf { item.isNegative } ?: "+"}${item.percent}%",
                    style = MaterialTheme.typography.body1,
                    color = red.takeIf { item.isNegative } ?: green
                )
            }
            Column(
                modifier = Modifier.weight(3f)
            ) {
                Text(text = item.symbol, style = MaterialTheme.typography.h3)
                Text(text = item.name, style = MaterialTheme.typography.body1)
            }
            Image(
                modifier = Modifier.weight(1f),
                painter = item.graph,
                contentDescription = "Graph"
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}
