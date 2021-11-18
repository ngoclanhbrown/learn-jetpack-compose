package com.brown.compose.layouts.ui.layout

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->

        val placeables = measurables.map {
            it.measure(constraints)
        }

        val width = placeables.maxOf { it.width }.coerceIn(
            constraints.minWidth..constraints.maxWidth
        )
        val height = placeables.sumOf { it.height }.coerceIn(
            constraints.minHeight..constraints.maxHeight
        )

        var yPosition = 0

        layout(width, height) {
            placeables.forEach {
                it.placeRelative(0, yPosition)
                yPosition += it.height
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewMyColumn() {
    MyColumn {
        Text(text = "Hello World")
        Text(text = "Hello Android")
        Text(text = "Hello Compose")
    }
}
