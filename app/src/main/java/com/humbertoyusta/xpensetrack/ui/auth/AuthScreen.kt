package com.humbertoyusta.xpensetrack.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.ui.shared.MainButton

@Composable
fun AuthScreen() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 32.dp, end = 32.dp, top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_currency_exchange),
                contentDescription = stringResource(R.string.app_icon),
                modifier = Modifier
                    .size(128.dp),
                tint = MaterialTheme.colorScheme.secondary,
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary,
            )
            Spacer(modifier = Modifier.size(32.dp))
            AuthInput(
                type = AuthInputType.Email,
                value = email.value,
                onValueChange = { email.value = it }
            )
            Spacer(modifier = Modifier.size(16.dp))
            AuthInput(
                type = AuthInputType.Password,
                value = password.value,
                onValueChange = { password.value = it }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row {
                Card(
                    modifier = Modifier.weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    MainButton(
                        text = stringResource(R.string.log_in),
                        enabled = email.value.isNotEmpty() && password.value.isNotEmpty(),
                        onClick = { /*TODO*/ }
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
                Card(
                    modifier = Modifier.weight(1f),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    MainButton(
                        text = stringResource(R.string.sign_up),
                        enabled = email.value.isNotEmpty() && password.value.isNotEmpty(),
                        onClick = { /*TODO*/ }
                    )
                }
            }
        }
    }
}