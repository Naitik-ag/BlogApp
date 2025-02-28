package com.example.blogapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.blogapp.ui.navigation.BlogNavHost
import com.example.blogapp.ui.viewmodel.BlogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogApp(
    navController: NavHostController = rememberNavController(),
    blogViewModel: BlogViewModel = hiltViewModel()
){
    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = { BlogAppBar(scrollBehaviour = scrollBehaviour , navController) }
    ) {contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ){
            BlogNavHost(
                navController,
                blogViewModel
            )
        }
    }

}

enum class BlogScreen(){
    Home,
    webview
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogAppBar(
    scrollBehaviour: TopAppBarScrollBehavior,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val showBackButton = currentBackStackEntry.value?.destination?.route?.contains(BlogScreen.webview.name) == true
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehaviour,
        title = { Text(text = "Blogs" , style = MaterialTheme.typography.displayMedium) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        modifier = modifier
    )
}
