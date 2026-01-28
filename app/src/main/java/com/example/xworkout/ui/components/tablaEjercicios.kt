package com.example.xworkout.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.xworkout.domain.model.Ejercicio
import com.example.xworkout.ui.theme.AccentWhite
import com.example.xworkout.ui.theme.PrimaryRed
import com.example.xworkout.ui.theme.SurfaceGray

@Composable
fun TablaEjercicios(ejercicio: Ejercicio, onReroll: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceGray),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = ejercicio.nombre, color = AccentWhite, style = MaterialTheme.typography.titleLarge)
                Text(text = ejercicio.reps, color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onReroll) {
                Icon(Icons.Default.AddCircle, contentDescription = "Reroll", tint = PrimaryRed)
            }
        }
    }
}