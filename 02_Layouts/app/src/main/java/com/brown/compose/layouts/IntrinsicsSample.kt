package com.brown.compose.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TwoTexts(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            text = text1,
            modifier = Modifier
                .weight(1F)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Divider(
            color = Color.Black,
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
        )
        Text(
            text = text2,
            modifier = Modifier
                .weight(1F)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewTwoTexts() {
    TwoTexts(text1 = "Hello", text2 = "World")
}
