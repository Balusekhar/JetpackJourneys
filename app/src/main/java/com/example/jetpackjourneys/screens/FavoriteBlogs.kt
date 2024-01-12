package com.example.jetpackjourneys.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoriteBlogs(navController:NavHostController) {
    Scaffold(
        content = {
            Text(text = "Fav")
        },
        bottomBar = { BottomBar(navController) },
    )
}