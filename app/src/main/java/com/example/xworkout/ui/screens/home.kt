package com.example.xworkout.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.* // Para manejar el estado
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.xworkout.ui.navigation.Routes


@Composable
fun homeView(navController: NavHostController) {
    var categoriaSeleccionada by remember { mutableStateOf("PUSH") }
    var tipoRutina by rememberSaveable { mutableStateOf("PUSH") }
    LazyColumn (
        modifier = Modifier.fillMaxSize().background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        item {


            Text(
                text = "X-WORKOUT ",
                fontSize = 35.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(top = 50.dp),
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(40.dp))


            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                val opciones = listOf("PUSH", "PULL", "LEGS", "FULL")

                opciones.forEach { nombre ->

                    val esSeleccionado = (categoriaSeleccionada == nombre)

                    Text(
                        text = nombre,
                        color = Color.White,
                        fontWeight = if (esSeleccionado) FontWeight.ExtraBold else FontWeight.Normal,
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = if (esSeleccionado) Color.Red else Color.Transparent,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = if (esSeleccionado) Color.DarkGray else Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            // 2. Aquí añadimos el evento de CLIC
                            .clickable {
                                categoriaSeleccionada = nombre
                                tipoRutina = nombre
                            }
                            .padding(horizontal = 15.dp, vertical = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(180.dp))

            Button(
                onClick = {
                    navController.navigate(Routes.Rutinas.route + "?tipoRutina=$categoriaSeleccionada")
                },
                modifier = Modifier
                    .size(200.dp)
                    .shadow(
                        elevation = 25.dp,
                        shape = CircleShape,
                        ambientColor = Color.Red,
                        spotColor = Color.Red
                    ),
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Red
                )
            ) {
                Text(
                    text = "X",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
        }
    }
}
