package com.brown.compose.basics

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.brown.compose.basics.screen.GreetingScreen
import com.brown.compose.basics.screen.OnboardScreen
import com.brown.compose.basics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                MyApp()
            }
        }
    }

}


@Composable
fun MyApp() {
    var showOnboardScreen by rememberSaveable { mutableStateOf(true) }

    if (showOnboardScreen) {
        OnboardScreen(onContinueClick = { showOnboardScreen = !showOnboardScreen })
    } else {
        GreetingScreen()
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewMyApp() {
    ComposeBasicsTheme {
        MyApp()
    }
}
