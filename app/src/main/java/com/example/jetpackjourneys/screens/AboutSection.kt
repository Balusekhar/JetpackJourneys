package com.example.jetpackjourneys.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackjourneys.R
import com.example.jetpackjourneys.navigation.Routes

@Composable
fun AboutScreen(navController:NavHostController) {
    Scaffold(
        content = {
            AboutContent(modifier = Modifier.padding(it))
        },
        bottomBar = { BottomBar(navController) },
    )
}

@Composable
private fun AboutContent(modifier:Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.placeholder_image),
            contentDescription = "Default Image",
            modifier = Modifier
                .padding(top = 36.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = CircleShape
                )
                .size(120.dp)
        )

        TextButton(onClick = { /*TODO*/ }) {
            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = "Name",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}