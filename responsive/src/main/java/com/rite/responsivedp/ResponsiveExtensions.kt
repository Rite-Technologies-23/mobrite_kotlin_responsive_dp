package com.rite.responsivedp

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Int.rdp: Dp
    @Composable
    get() = this.dp.responsive()

val Float.rdp: Dp
    @Composable
    get() = this.dp.responsive()

val Double.rdp: Dp
    @Composable
    get() = this.toFloat().dp.responsive()

val Int.rsp: TextUnit
    @Composable
    get() = this.sp.responsive()

val Float.rsp: TextUnit
    @Composable
    get() = this.sp.responsive()

val Double.rsp: TextUnit
    @Composable
    get() = this.toFloat().sp.responsive()