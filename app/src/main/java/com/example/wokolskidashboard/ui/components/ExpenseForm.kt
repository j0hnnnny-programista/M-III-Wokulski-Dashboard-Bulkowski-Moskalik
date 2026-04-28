package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
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
    var error by remember { mutableStateOf(false) }
    var wybranaKategoria by remember { mutableStateOf("Sklep") }
    val listaKategorii = listOf("Sklep", "Kamienica", "Zbyteczne")

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = "Wydatki", style = MaterialTheme.typography.titleLarge)

        Box(modifier = Modifier.height(64.dp)) {
            WokulskiTextField(value = nazwa, onValueChange = { nazwa = it }, label = "Cel wydatku")
        }

        Box(modifier = Modifier.height(64.dp)) {
            WokulskiTextField(value = kwotaStr, onValueChange = { kwotaStr = it }, label = "Kwota")
        }

        Text(text = "Kategoria:", style = MaterialTheme.typography.labelLarge)
        Column {
            listaKategorii.forEach { kategoria ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { wybranaKategoria = kategoria }
                        .padding(vertical = 4.dp)
                ) {
                    RadioButton(
                        selected = (wybranaKategoria == kategoria),
                        onClick = { wybranaKategoria = kategoria }
                    )
                    Text(text = kategoria)
                }
            }
        }

        if (error) {
            Text(text = "Błędne dane", color = MaterialTheme.colorScheme.error)
        }

        WokulskiButton(text = "Dodaj Koszt", onClick = {
            val kwota = kwotaStr.toDoubleOrNull()
            if (nazwa.isNotBlank() && kwota != null && kwota > 0) {
                val czyZbyteczny = (wybranaKategoria == "Zbyteczne")
                val ostatecznaNazwa = if (czyZbyteczny) nazwa else "[$wybranaKategoria] $nazwa"

                onAddExpense(ostatecznaNazwa, kwota, czyZbyteczny)

                nazwa = ""
                kwotaStr = ""
                wybranaKategoria = "Sklep"
                error = false
            } else {
                error = true
            }
        })
    }
}

@Preview
@Composable
fun ExpenseFormPreview() {
    WokolskiDashBoardTheme {
        Surface {
            ExpenseForm(onAddExpense = { _, _, _ -> })
        }
    }
}