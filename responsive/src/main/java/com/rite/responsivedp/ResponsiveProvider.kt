package com.rite.responsiveDp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.rite.responsivedp.ResponsiveScale

val LocalResponsiveScale =
    compositionLocalOf { ResponsiveScale() }

@Composable
fun ResponsiveTheme(
    scale: ResponsiveScale = ResponsiveScale(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalResponsiveScale provides scale,
        content = content
    )
}