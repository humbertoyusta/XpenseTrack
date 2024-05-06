package com.humbertoyusta.xpensetrack.home

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 14.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
                )
                .fillMaxWidth()
                .padding(
                    start = 56.dp,
                    end = 56.dp,
                    top = 20.dp,
                    bottom = 34.dp
                )
        ) {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "Home",
                modifier = Modifier.size(30.dp)
            )
            Icon(
                imageVector = Icons.Rounded.Settings,
                contentDescription = "Settings",
                modifier = Modifier.size(30.dp)
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
                    .padding(14.dp)
            )
        }
    }
}
