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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import com.example.xworkout.R

@Preview(showBackground = true)
@Composable
fun perfilView(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn (Modifier
            .fillMaxSize()
            .background(Color.DarkGray)) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .border(2.dp, Color.Black,shape = RoundedCornerShape(10.dp))
                        .padding(10.dp)) {

                    Image(painter = painterResource(R.drawable.logo_x_workout),
                        contentDescription = null, modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .border(
                                2.dp, Color.Red,
                                shape = CircleShape
                            ))

                    Column(horizontalAlignment = Alignment.CenterHorizontally, // Centra el contenido
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .wrapContentHeight()) {

                        Text(text = "X-WORKOUTPerfil", color = Color.Red,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(text = "Nivel: DEFAULT")

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            ),

                            modifier = Modifier
                                .padding(top = 8.dp)
                                .border(2.dp, Color.Red, shape = RoundedCornerShape(12.dp)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Editar Perfil",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .border(2.dp, Color.Black,shape = RoundedCornerShape(10.dp))
                        .padding(10.dp)) {

                    Text(text = "SETTINGS", color = Color.White)

                    FilaSettings("Barra de dominadas",false,{})
                    FilaSettings("Anillas de gimnasia",false,{})
                    FilaSettings("paralelas altas",false,{})
                    FilaSettings("paralelas bajas",false,{})
                    FilaSettings("Barra de dominadas",false,{})

                }

                Spacer(modifier = Modifier.height(10.dp))

                Column (verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .border(2.dp, Color.Black,shape = RoundedCornerShape(10.dp))
                        .height(150.dp)
                        .padding(10.dp)) {

                    Text(text = "Estadisticas", color = Color.White, fontSize = 20.sp)

                    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "TOTAL DE ENTRENAMIENTOS:", color = Color.White)
                        Text(text = "0", color = Color.White)
                    }

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "TOTAL DE Volumen:", color = Color.White)
                        Text(text = "0", color = Color.White)
                    }
                }
            }

        }

    }
}

@Composable
fun FilaSettings(
    label: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.White, fontSize = 16.sp)
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Red,
                checkedThumbColor = Color(0xFF1C1C1C)
            )
        )
    }
}