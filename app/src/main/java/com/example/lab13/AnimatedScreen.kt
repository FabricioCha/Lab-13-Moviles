package com.example.lab13
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab13.ui.theme.Lab13Theme
@Composable
fun AnimatedScreen() {
    var isClicked by remember { mutableStateOf(false) }
    var isButtonVisible by remember { mutableStateOf(true) }
    var isDarkMode by remember { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if (isClicked) 150.dp else 100.dp,
        animationSpec = tween(durationMillis = 500)
    )

    val color by animateColorAsState(
        targetValue = if (isClicked) Color.Green else Color.Blue,
        animationSpec = tween(durationMillis = 500)
    )

    val buttonOffsetX by animateDpAsState(
        targetValue = if (isButtonVisible) 0.dp else 300.dp,
        animationSpec = tween(durationMillis = 800)
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isDarkMode) Color.Black else Color.White,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cuadro que cambia de tamaño y color
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color)
            )

            Spacer(modifier = Modifier.height(32.dp))

            AnimatedVisibility(
                visible = isButtonVisible,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                Button(onClick = {
                    isClicked = !isClicked
                    isButtonVisible = !isButtonVisible
                }) {
                    Text("Cambiar Tamaño y Color")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { isDarkMode = !isDarkMode }) {
                Text(text = if (isDarkMode) "Modo Claro" else "Modo Oscuro")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab13Theme {
        AnimatedScreen()
    }
}


