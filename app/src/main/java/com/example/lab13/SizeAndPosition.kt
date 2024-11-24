package com.example.lab13

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SizeAndPositionAnimationExample() {
    var isMoved by remember { mutableStateOf(false) }
    var isBig by remember { mutableStateOf(false) }

    val size by animateDpAsState(targetValue = if (isBig) 200.dp else 100.dp)

    val offsetX by animateDpAsState(targetValue = if (isMoved) 200.dp else 0.dp)
    val offsetY by animateDpAsState(targetValue = if (isMoved) 200.dp else 0.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offsetX, y = offsetY)
                .background(Color.Blue)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            isMoved = !isMoved
            isBig = !isBig
        }) {
            Text(text = "Mover y Cambiar Tamaño")
        }
    }
}




