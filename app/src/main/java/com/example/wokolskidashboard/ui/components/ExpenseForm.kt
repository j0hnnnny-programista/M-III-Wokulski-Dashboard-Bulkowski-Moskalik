package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

@Composable
fun ExpenseForm(onAddExpense: (String, Double, Boolean) -> Unit) {
    var nazwa by remember { mutableStateOf("") }
    var kwotaStr by remember { mutableStateOf("") }
    var isUnnecesary by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = "Wydatki", style = MaterialTheme.typography.titleLarge)

        Box(modifier = Modifier.height(64.dp)) {
            WokulskiTextField(value = nazwa, onValueChange = { nazwa = it }, label = "Cel wydatku")
        }

        Box(modifier = Modifier.height(64.dp)) {
            WokulskiTextField(value = kwotaStr, onValueChange = { kwotaStr = it }, label = "Kwota")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = isUnnecesary, onCheckedChange = { isUnnecesary = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Wydatek zbyteczny")
        }

        if (error) {
            Text(text = "Błędne dane", color = MaterialTheme.colorScheme.error)
        }

        WokulskiButton(text = "Dodaj Koszt", onClick = {
            val kwota = kwotaStr.toDoubleOrNull()
            if (nazwa.isNotBlank() && kwota != null && kwota > 0) {
                onAddExpense(nazwa, kwota, isUnnecesary)
                nazwa = ""
                kwotaStr = ""
                isUnnecesary = false
                error = false
            } else {
                error = true
            }
        })
    }
}