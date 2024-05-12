package com.humbertoyusta.xpensetrack.home.ui

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.add_transaction.AddTransactionActivity
import com.humbertoyusta.xpensetrack.home.HomeActivity
import com.humbertoyusta.xpensetrack.ui.currency.CurrencyActivity

@Composable
fun BottomAppBar() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 56.dp,
                    end = 56.dp,
                    top = 20.dp,
                    bottom = 0.dp
                )
        ) {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "Home",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        val intent = Intent(context, HomeActivity::class.java)
                        context.startActivity(intent)
                    },
                tint = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(id = R.drawable.round_currency_exchange),
                contentDescription = "Settings",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        val intent = Intent(context, CurrencyActivity::class.java)
                        context.startActivity(intent)
                    },
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-28).dp)
                .size(72.dp)
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(36.dp),
                    clip = false
                )
                .clip(RoundedCornerShape(36.dp))
                .clickable {
                    val intent = Intent(context, AddTransactionActivity::class.java)
                    context.startActivity(intent)
                }
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add",
                modifier = Modifier
                    .size(72.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.tertiary
                            )
                        ),
                        shape = RoundedCornerShape(36.dp)
                    )
                    .padding(14.dp),
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}
