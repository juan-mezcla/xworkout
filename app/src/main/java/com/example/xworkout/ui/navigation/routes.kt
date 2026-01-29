package com.example.xworkout.ui.navigation


import com.example.xworkout.R
import androidx.compose.material3.Icon

sealed class Routes(val titulo: String, val icono: Int,val route: String){
    object Home: Routes("Home", R.drawable.ic_home, "home")
    object Historial: Routes("Historial", R.drawable.ic_history, "historial")
    object Rutinas: Routes("Rutinas", R.drawable.ic_rutinas, "rutinas")
    object Perfil: Routes("Perfil", R.drawable.ic_perfil, "perfil")
}