package com.example.blogapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.blogapp.ui.screen.BlogScreen
import com.example.blogapp.ui.screen.HomeScreen
import com.example.blogapp.ui.screen.WebView
import com.example.blogapp.ui.viewmodel.BlogViewModel


@Composable
fun BlogNavHost(
    navController: NavHostController,
    blogViewModel: BlogViewModel,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = BlogScreen.Home.name,
        modifier = modifier
    ){
        composable(route = BlogScreen.Home.name){
            HomeScreen(blogViewModel,navController)
        }
        composable(
            route = "${BlogScreen.webview.name}/{url}",
            arguments = listOf(navArgument("url"){type = NavType.StringType})
        ){
            backStackEntry ->
            val url = backStackEntry.arguments?.getString("url")
            if (url != null) {
                WebView(url)
            }
        }
    }
}