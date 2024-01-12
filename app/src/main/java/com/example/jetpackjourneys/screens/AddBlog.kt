package com.example.jetpackjourneys.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackjourneys.util.CustomButton
import com.example.jetpackjourneys.util.TextInputField

@Composable
fun AddBlog() {

    var title by remember {
        mutableStateOf("")
    }

    var content by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextInputField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            value = title,
            label = "Add Your Blog Title",
            maxLines = true
        ) { title = it }

        TextInputField(
            modifier = Modifier
                .padding(bottom = 12.dp, start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .weight(1f),
            value = content,
            maxLines = false,
            label = "Add Your Blog Content"
        ) { content = it }

        CustomButton(label = "SAVE") {
            
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddBlogPreview() {
    AddBlog()
}