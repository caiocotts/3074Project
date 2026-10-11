package ca.georgebrown.keags.a3074project.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class NavRoutes(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    SEARCH("search", "Search", Icons.Default.Search),
    CREATE("create", "Create", Icons.Default.Add),
    DETAILS("details", "Details", Icons.Default.List),
    EDIT("edit", "Edit", Icons.Default.Edit),
    DIRECTIONS("directions", "Directions", Icons.Default.Map)
}

@Composable
fun Nav(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    val selectedScreen by navController.currentBackStackEntryAsState()
    val currentRoute = selectedScreen?.destination?.route

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavRoutes.entries.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentRoute == navItem.route,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(navItem.icon, contentDescription = navItem.label) },
                        label = { Text(navItem.label) }
                    )
                }
            }
        }
    ){
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.SEARCH.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(NavRoutes.SEARCH.route){
                SearchScreen()
            }
            composable(NavRoutes.CREATE.route){
                Create()
            }
            composable(NavRoutes.DETAILS.route){
                DetailsScreen()
            }
            composable(NavRoutes.EDIT.route){
                Edit()
            }
            composable(NavRoutes.DIRECTIONS.route){
                DirectionListScreen()
            }
        }
    }
}