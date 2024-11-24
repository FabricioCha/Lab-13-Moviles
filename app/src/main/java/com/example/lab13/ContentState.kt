package com.example.lab13
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab13.ui.theme.Lab13Theme
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ContentStateExample() {
    var currentState by remember { mutableStateOf(State.Loading) }
    AnimatedContent(
        targetState = currentState,
        transitionSpec = {
            fadeIn(animationSpec = tween(1000)) togetherWith fadeOut(animationSpec = tween(1000))
        }, label = ""
    ) { targetState ->
        when (targetState) {
            State.Loading -> {
                Text("Cargando...", modifier = Modifier.fillMaxSize(), style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp))
            }
            State.Content -> {
                Text("Contenido cargado exitosamente", modifier = Modifier.fillMaxSize(), style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp))
            }
            State.Error -> {
                Text("Error al cargar el contenido", modifier = Modifier.fillMaxSize(), style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp))
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { currentState = State.Loading }) {
            Text("Cargar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { currentState = State.Content }) {
            Text("Mostrar Contenido")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { currentState = State.Error }) {
            Text("Mostrar Error")
        }
    }
}

enum class State {
    Loading,
    Content,
    Error
}
@Preview(showBackground = true)
@Composable
fun ContentStatePreview() {
    Lab13Theme {
        ContentStateExample()
    }
}
