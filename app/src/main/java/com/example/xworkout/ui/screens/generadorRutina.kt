package com.example.xworkout.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.xworkout.R


@Composable
fun generadorRutina(tipo: String) {

        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Text(text = "$tipo aa", modifier = Modifier.padding(16.dp))
            LazyColumn () {

                item {
                    Column() {
                        Row() {
                            Image(painter = painterResource(R.drawable.ic_history),contentDescription = null)

                            Column() {
                                Row() {
                                    Text(text = "titulo ejercicio")
                                    Button(onClick = {}) {
                                        Image(painter = painterResource(R.drawable.ic_history),contentDescription = null)
                                    }
                                }

                                Text(text = "titulo ejercicio")

                                Row() {
                                    TextField(value = "actual reps")

                                    Button(onClick = {}) {
                                        Text(text = "Terminado")
                                    }
                                }
                            }
                        }

                    }
                }

            }
        }

}

@Preview
@Composable
fun rutinaGenerada(){

}