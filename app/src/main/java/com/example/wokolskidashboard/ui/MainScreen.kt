package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.*
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

@Composable
fun MainScreen() {
    val transactions = remember { mutableStateListOf<Transaction>() }
    val balance = transactions.sumOf { if (it.isExpence) -it.kwota else it.kwota }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            BalanceHeader(balance = balance)

            IncomeForm(onAddIncome = { n, k ->
                transactions.add(0, Transaction(nazwa = n, kwota = k, isExpence = false, isUnnecesary = false))
            })

            HorizontalDivider()

            ExpenseForm(onAddExpense = { n, k, u ->
                transactions.add(0, Transaction(nazwa = n, kwota = k, isExpence = true, isUnnecesary = u))
            })

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(transactions) { item ->
                    TransactionCard(transaction = item)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    WokolskiDashBoardTheme {
        Surface {
            MainScreen()
        }
    }
}
