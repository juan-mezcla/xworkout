package com.example.xworkout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.xworkout.ui.navigation.Routes
import com.example.xworkout.ui.screens.generadorRutina
import com.example.xworkout.ui.screens.historialView
import com.example.xworkout.ui.screens.homeView
import com.example.xworkout.ui.screens.perfilView
import com.example.xworkout.ui.theme.XworkoutTheme
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XWorkoutApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun XWorkoutApp() {
    XworkoutTheme {

        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MenuBotton(navController) },
            containerColor = Color(0xFF1C1C1C)
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationGraph(navController)
            }
        }
    }
}

@Composable
fun MenuBotton(navigationController: NavController) {
    val pantallas = listOf(
        Routes.Home,
        Routes.Historial,
        Routes.Rutinas,
        Routes.Perfil
    )

    NavigationBar(
        containerColor = Color.Black, // Aquí cambias el fondo
        contentColor = Color.White,   // Color de los elementos (opcional)
        tonalElevation = 8.dp) {
        val navBackStackEntry by navigationController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        pantallas.forEach { pantalla ->
            // Esta lógica es más precisa:
            val isSelected = when {
                pantalla.route == Routes.Home.route -> currentRoute == Routes.Home.route
                else -> currentRoute?.startsWith(pantalla.route) == true
            }

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navigationController.navigate(pantalla.route) {
                        popUpTo(navigationController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(painter = painterResource(id = pantalla.icono), contentDescription = null) },
                label = { Text(text = pantalla.titulo) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.White
                )
            )
        }
    }
}

@Composable
fun NavigationGraph(navigationController: NavHostController) {
    NavHost(
        navController = navigationController,
        startDestination = Routes.Home.route
    ) {
        composable(route = Routes.Home.route) {
            homeView(navController = navigationController)
        }

        composable(route = Routes.Historial.route) {
            historialView()
        }

        // UNIFICAMOS: El nombre dentro de las llaves {} debe ser igual al que pides en getString
        composable(
            route = Routes.Rutinas.route + "?tipoRutina={tipoRutina}",
            arguments = listOf(
                navArgument("tipoRutina") {
                    defaultValue = "LIBRE"
                }
            )
        ) { backStackEntry ->
            val tipo = backStackEntry.arguments?.getString("tipoRutina") ?: "LIBRE"
            generadorRutina(tipo)
        }

        composable(route = Routes.Perfil.route) {
            perfilView()
        }
    }
}