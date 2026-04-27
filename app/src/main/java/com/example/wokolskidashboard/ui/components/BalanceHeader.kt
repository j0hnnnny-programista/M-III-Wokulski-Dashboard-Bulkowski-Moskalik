package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

@Composable
fun BalanceHeader(balance: Double) {
    val color = if (balance >= 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Aktualne Saldo", style = MaterialTheme.typography.labelLarge)
        Text(
            text = String.format("%.2f Rub", balance),
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = color
        )
    }
}

@Preview
@Composable
fun BalanceHeaderPreview() {
    WokolskiDashBoardTheme {
        Surface {
            BalanceHeader(balance = 150.0)
        }
    }
}