package com.example.jetpackjourneys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.jetpackjourneys.navigation.NavHost
import com.example.jetpackjourneys.ui.theme.JetpackJourneysTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackJourneysTheme {
                NavHost(navController = rememberNavController())
            }
        }
    }
}
