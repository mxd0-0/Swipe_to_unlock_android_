package com.example.swipetounlock

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(modifier: Modifier = Modifier) {
    val naveControl = rememberNavController()
    NavHost(navController = naveControl, startDestination = "home") {
        composable("home") { Welcome(navController = naveControl) }
        composable("quotes") { Quote(navController = naveControl) }
    }

}