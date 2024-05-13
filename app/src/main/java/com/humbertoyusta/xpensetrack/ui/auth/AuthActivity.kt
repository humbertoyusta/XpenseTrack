package com.humbertoyusta.xpensetrack.ui.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpenseTrackTheme {
                AuthScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    XpenseTrackTheme {
        AuthScreen()
    }
}