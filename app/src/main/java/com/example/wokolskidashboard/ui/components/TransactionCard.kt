package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

@Composable
fun TransactionCard(transaction: Transaction) {
    val backgroundColor = if (transaction.isExpence) Color(0xFFFFEBEE) else Color(0xFFE8F5E9)
    val textColor = if (transaction.isExpence) Color(0xFFC62828) else Color(0xFF2E7D32)
    val sign = if (transaction.isExpence) "-" else "+"

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = transaction.nazwa, fontWeight = FontWeight.Bold)
                if (transaction.isExpence && transaction.isUnnecesary) {
                    Text(text = "Wydatek zbyteczny", style = MaterialTheme.typography.bodySmall)
                }
            }
            Text(
                text = "$sign${transaction.kwota} Rub",
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun TransactionCardPreview() {
    WokolskiDashBoardTheme {
        Surface {
            TransactionCard(
                transaction = Transaction("Kareta", 500.0, isExpence = true, isUnnecesary = true)
            )
        }
    }
}