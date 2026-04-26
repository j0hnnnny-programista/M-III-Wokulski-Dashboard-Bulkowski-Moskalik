package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

@Composable
fun IncomeForm(onAddIncome: (String, Double) -> Unit) {
    var nazwa by remember { mutableStateOf("") }
    var kwotaStr by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = "Przychody", style = MaterialTheme.typography.titleLarge)

        Box(modifier = Modifier.height(64.dp)) {
            WokulskiTextField(value = nazwa, onValueChange = { nazwa = it }, label = "Nazwa towaru")
        }

        Box(modifier = Modifier.height(64.dp)) {
            WokulskiTextField(value = kwotaStr, onValueChange = { kwotaStr = it }, label = "Kwota")
        }

        if (error) {
            Text(text = "Błędne dane", color = MaterialTheme.colorScheme.error)
        }

        WokulskiButton(text = "Dodaj Zysk", onClick = {
            val kwota = kwotaStr.toDoubleOrNull()
            if (nazwa.isNotBlank() && kwota != null && kwota > 0) {
                onAddIncome(nazwa, kwota)
                nazwa = ""
                kwotaStr = ""
                error = false
            } else {
                error = true
            }
        })
    }
}


