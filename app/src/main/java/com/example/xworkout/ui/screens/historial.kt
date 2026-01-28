package com.example.xworkout.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun historialView(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
            ,modifier = Modifier.fillMaxSize()
                .padding(15.dp).height(90.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Historial de rutinas", color = Color.Red,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 25.sp)

            Spacer(modifier = Modifier.padding(5.dp))

            Text(text = "Desliza para eliminar", color = Color.LightGray,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 15.sp)

            Spacer(modifier = Modifier.padding(20.dp))

            Row(Modifier.fillMaxWidth()) {
                LazyColumn(modifier = Modifier.wrapContentHeight()
                    .fillMaxWidth()) {


                    item {
                        // Quitamos la Column intermedia que no aportaba nada
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                // 1. EL FONDO: Debe tener el mismo shape que el borde para no salirse de las esquinas
                                .background(Color(0xFF2B2B2B), shape = RoundedCornerShape(10.dp))
                                // 2. EL BORDE
                                .border(2.dp, Color.Red, shape = RoundedCornerShape(10.dp))
                                .wrapContentHeight()
                                .padding(25.dp) // El padding va AL FINAL para que sea espacio interno
                        ) {
                            Column {
                                Text(
                                    text = "Fecha",
                                    color = Color.White,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "Tipo rutina",
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = "tiempo · calorias · dificultad",
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                                    color = Color.LightGray,
                                    fontSize = 14.sp
                                )
                            }

                            Image(
                                painter = painterResource(com.example.xworkout.R.drawable.logo_x_workout),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, Color.Red, shape = CircleShape)
                            )
                        }

                    }
                }
            }
        }



    }
}