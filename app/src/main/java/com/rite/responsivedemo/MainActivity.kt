package com.rite.responsivedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rite.responsivedemo.ui.theme.ResponsiveDpTheme
import com.rite.responsivedp.rdp
import com.rite.responsivedp.rsp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ResponsiveDpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ResponsiveDemo()
                }
            }
        }
    }
}

@Composable
fun ResponsiveDemo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "ResponsiveDp Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        HorizontalDivider()

        CompareText(12)
        CompareText(14)
        CompareText(16)
        CompareText(18)
        CompareText(20)
        CompareText(24)
        CompareText(28)
        CompareText(32)

        HorizontalDivider()

        Text("Responsive Box Sizes")

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            BoxSample(
                title = "100.dp",
                size = 100.dp
            )

            BoxSample(
                title = "100.rdp",
                size = 100.rdp
            )
        }
    }
}

@Composable
private fun CompareText(size: Int) {

    Column {

        Text("Normal ${size}sp")

        Text(
            text = "Hello Responsive Library",
            fontSize = size.dp.value.let { androidx.compose.ui.unit.TextUnit(it, androidx.compose.ui.unit.TextUnitType.Sp) }
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text("Responsive ${size}.rsp")

        Text(
            text = "Hello Responsive Library",
            fontSize = size.rsp
        )

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()
    }
}

@Composable
private fun BoxSample(
    title: String,
    size: androidx.compose.ui.unit.Dp
) {

    Column {

        Text(title)

        Spacer(modifier = Modifier.height(8.dp))

        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(size)
                .border(1.dp, MaterialTheme.colorScheme.primary)
        )
    }
}