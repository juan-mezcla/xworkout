package com.example.xworkout.ui.navigation

import android.R
import androidx.compose.material3.Icon

sealed class Routes(val titulo: String, val icono: Int,val route: String){
    object Home: Routes("Home", R.drawable.ic_menu_more, "home")
    object Historial: Routes("Historial", R.drawable.ic_menu_more, "historial")
    object Rutinas: Routes("Rutinas", R.drawable.ic_menu_more, "rutinas")
    object Perfil: Routes("Perfil", R.drawable.ic_menu_more, "perfil")
}