package com.brown.compose.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brown.compose.layouts.ui.theme.ComposeLayoutsTheme
import kotlinx.coroutines.launch

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
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier) {
        LazyColumn(
            state = lazyListState,
            contentPadding = PaddingValues(vertical = 4.dp),
            modifier = Modifier.weight(1F)
        ) {
            items(20) {
                PhotographerCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
        }
        Row {
            Button(
                modifier = Modifier
                    .weight(1F)
                    .padding(8.dp),
                onClick = {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(0)
                    }
                }
            ) {
                Text(text = "Scroll to start")
            }
            Button(
                modifier = Modifier
                    .weight(1F)
                    .padding(8.dp),
                onClick = {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(19)
                    }
                }
            ) {
                Text(text = "Scroll to end")
            }
        }
    }
}


@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
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
}


@Preview(showBackground = true)
@Composable
fun PreviewPhotographerCard() {
    ComposeLayoutsTheme {
        PhotographerCard()
    }
}
