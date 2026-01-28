package com.example.xworkout.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun generadorRutina(tipo: String) {

        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Text(text = "$tipo aa", modifier = Modifier.padding(16.dp))

        }

}