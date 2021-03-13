package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.ui.graphics.painter.Painter

data class Position(
    val price: String,
    val isNegative: Boolean,
    val percent: Float,
    val symbol: String,
    val name: String,
    val graph: Painter
)
