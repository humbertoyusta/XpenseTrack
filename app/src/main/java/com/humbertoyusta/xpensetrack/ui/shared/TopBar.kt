package com.humbertoyusta.xpensetrack.ui.shared

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R

enum class Action {
    Close,
    LogOut,
}

@Composable
fun TopBar(
    action: Action,
    logOut: () -> Unit = {},
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                if (action == Action.LogOut) {
                    logOut()
                }
                (context as? Activity)?.finish()
            },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
        ) {
            Icon(
                painter = painterResource(
                    id = if (action == Action.Close) {
                        R.drawable.round_close
                    } else {
                        R.drawable.round_logout
                    }
                ),
                contentDescription = if (action == Action.Close)
                    stringResource(R.string.close)
                else
                    stringResource(R.string.log_out),
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}