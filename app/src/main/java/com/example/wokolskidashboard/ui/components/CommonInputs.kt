package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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