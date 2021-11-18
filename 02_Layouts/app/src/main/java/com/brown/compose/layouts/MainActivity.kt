package com.brown.compose.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brown.compose.layouts.ui.theme.ComposeLayoutsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ScaffoldApp()
                }
            }
        }
    }

}


@Composable
fun ScaffoldApp() {
    Scaffold(
        topBar = { AppBar() }
    ) { innerPadding ->
        AppBody(modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(text = "Compose Layouts")
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        }
    )
}


@Composable
fun AppBody(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        PhotographerCard(modifier = Modifier.align(Alignment.Center))
    }
}


@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable { }
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2F)
        ) {

        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPhotographerCard() {
    ComposeLayoutsTheme {
        PhotographerCard()
    }
}
