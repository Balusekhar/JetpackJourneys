package com.example.jetpackjourneys.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextInputField(
    modifier: Modifier,
    value: String,
    maxLines : Boolean,
    label: String = "Enter Your Email",
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = MaterialTheme.colorScheme.primary,
        ),
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label) },
        maxLines = if (maxLines) 1 else Int.MAX_VALUE
    )
}

@Composable
fun CustomButton(label:String, onButtonCLicked: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colorScheme.primary),
        onClick = onButtonCLicked
    ) {
        Text(text = label, fontSize = 20.sp)
    }
}