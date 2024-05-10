package com.humbertoyusta.xpensetrack.add_transaction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.data.enums.TransactionCategory

@Composable
fun CategorySelect(
    transactionCategory: MutableState<TransactionCategory?>
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = { expanded = true },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .align(Alignment.Start),
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_checklist),
                    contentDescription = "Category check list",
                    tint = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .padding(vertical = 14.dp)
                        .background(
                            color = MaterialTheme.colorScheme.onSurface,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(24.dp)
                        .padding(2.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = if (transactionCategory.value == null)
                        "Select a category"
                    else
                        transactionCategory.value!!.name
                            .lowercase()
                            .replaceFirstChar { it.uppercase() },
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            properties = PopupProperties(clippingEnabled = true),
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            offset = DpOffset(x = 32.dp, y = 0.dp)
        ) {
            TransactionCategory.entries.forEach { category ->
                DropdownMenuItem(
                    text = {
                        Text(text = category.name
                            .lowercase()
                            .replaceFirstChar { it.uppercase() })
                    },
                    onClick = {
                        transactionCategory.value = category
                        expanded = false
                    },
                )
            }
        }
    }
}