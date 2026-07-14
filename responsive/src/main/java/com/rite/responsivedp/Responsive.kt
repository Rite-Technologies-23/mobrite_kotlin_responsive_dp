package com.rite.responsivedp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun Dp.responsive(): Dp {

    val config = LocalConfiguration.current
    val scales = LocalResponsiveScale.current

    val shortest =
        minOf(
            config.screenWidthDp,
            config.screenHeightDp
        )

    val isTablet = shortest >= 600

    val sw =
        if (isTablet)
            config.screenWidthDp
        else
            shortest

    val factor = when {
        sw < 360 -> scales.smallPhone
        sw < 480 -> scales.phone
        sw < 600 -> scales.largePhone
        sw < 840 -> scales.tablet
        else -> scales.largeTablet
    }

    return this * factor
}

@Composable
fun TextUnit.responsive(): TextUnit {

    val config = LocalConfiguration.current
    val scales = LocalResponsiveScale.current

    val shortest =
        minOf(
            config.screenWidthDp,
            config.screenHeightDp
        )

    val isTablet = shortest >= 600

    val sw =
        if (isTablet)
            config.screenWidthDp
        else
            shortest

    val factor = when {
        sw < 360 -> scales.smallPhone
        sw < 480 -> scales.phone
        sw < 600 -> scales.largePhone
        sw < 840 -> scales.tablet
        else -> scales.largeTablet
    }

    return this * factor
}