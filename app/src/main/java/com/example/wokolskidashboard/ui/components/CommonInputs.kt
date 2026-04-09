package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

@Composable
fun WokulskiTextField(
    value: String,
    onValueChange: (String)-> Unit,
    label: String,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {Text(label)},
        modifier = modifier
            .fillMaxWidth(),
        singleLine = true
    )

}
@Composable
fun WokulskiButton(
    text: String,
    onClick:()-> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium
    ){
        Text(text = text)
    }
}