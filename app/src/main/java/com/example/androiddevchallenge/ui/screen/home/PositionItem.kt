package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
