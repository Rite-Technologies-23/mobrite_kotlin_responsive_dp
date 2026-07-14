package com.rite.responsivedp

import androidx.compose.runtime.Immutable

@Immutable
data class ResponsiveScale(
    val smallPhone: Float = 0.90f,
    val phone: Float = 1.0f,
    val largePhone: Float = 1.08f,
    val tablet: Float = 1.20f,
    val largeTablet: Float = 1.35f
)