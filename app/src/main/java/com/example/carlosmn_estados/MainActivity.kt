package com.example.carlosmn_estados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carlosmn_estados.ui.theme.CarlosMN_estadosTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarlosMN_estadosTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 36.dp).padding(18.dp)
                ) {
                    //estados_a()
                    //estados_b()
                    //estados_c()
                    estados_d()
                }
            }
        }
    }
}
@Preview
@Composable
fun estados_d() {
         var num1 by rememberSaveable { mutableStateOf("") }
         var num2 by rememberSaveable { mutableStateOf("") }
         var resultado by rememberSaveable { mutableStateOf("") }

         Column(
             modifier = Modifier.fillMaxSize().padding(16.dp),
             verticalArrangement = Arrangement.Center, // Centra verticalmente
             horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
         ) {
             TextField(
                 value = num1,
                 onValueChange = { num1 = it },
                 label = { Text("Número 1") },
                 modifier = Modifier.fillMaxWidth().padding(8.dp)
             )
             Spacer(modifier = Modifier.width(16.dp)) // Espacio de 16dp entre TextField
             TextField(
                 value = num2,
                 onValueChange = { num2 = it },
                 label = { Text("Número 2") },
                 modifier = Modifier.fillMaxWidth().padding(8.dp)
             )
             // Primera Fila de botones
             Row {
                 Button(
                     onClick = { resultado = (num1.toFloat() + num2.toFloat()).toString() }
                 )
                 {
                     Text("Sumar")
                 }
                 Spacer(modifier = Modifier.width(16.dp)) // Espacio de 16dp entre botones
                 Button(
                     onClick = { resultado = (num1.toFloat() + num2.toFloat()).toString() }
                 )
                 {
                     Text("Restar")
                 }
             }
            // Segunda Fila de botones
             Row {
                 Button(
                     onClick = { resultado = (num1.toFloat() * num2.toFloat()).toString() }
                 )
                 {
                     Text("Multiplicar")
                 }
                 Spacer(modifier = Modifier.width(16.dp)) // Espacio de 16dp entre botones
                 Button(
                     onClick = { resultado = (num1.toFloat() / num2.toFloat()).toString() }
                 )
                 {
                     Text("Dividir")
                 }
             }

             Text(text = "Resultado: $resultado")
         }
     }

@Preview
@Composable
fun estados_c() {
        var backgroundColor by remember { mutableStateOf(Color.White) } // Estado para el color de fondo
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa toda la pantalla
                .background(backgroundColor) // Aplica el color de fondo
                .padding(16.dp), // Margen de 16dp alrededor
            verticalArrangement = Arrangement.Center, // Centra verticalmente
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
        ) {
            // Botón para poner el fondo en rojo
            Button(
                onClick = { backgroundColor = Color.Red },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Rojo")
            }

            // Botón para poner el fondo en verde
            Button(
                onClick = { backgroundColor = Color.Green },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Verde")
            }

            // Botón para poner el fondo en azul
            Button(
                onClick = { backgroundColor = Color.Blue },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Azul")
            }
        }

     }

@Preview
@Composable
fun estados_b() {
        // Variable de estado para almacenar el texto ingresado por el usuario
        var text by rememberSaveable { mutableStateOf("") }
        var error by rememberSaveable { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa toda la pantalla
                .padding(16.dp), // Margen de 16dp alrededor
            verticalArrangement = Arrangement.Center, // Centra verticalmente
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
        ) {
            // Campo de texto para ingresar texto
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                    error = newText.isEmpty() // Actualiza el estado de error si el texto está vacío
                },
                label = { Text("Ingrese texto") }, // Etiqueta para el TextField
                isError = error, // Indica si hay un error
                modifier = Modifier.fillMaxWidth()
            )
            if (error) {
                Text(
                    text = "Error: Obligatorio",
                    color = Color.Red
                )
            } else {
                Text(
                    text = "*Obligatorio",
                    color = Color.Gray
                )
            }

            // Muestra el texto ingresado en un fondo amarillo
            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 40.dp).fillMaxWidth()
                    .background(Color.Transparent)
                    .height(40.dp)
            )

            // Botón para limpiar el texto
            Button(
                onClick = {
                    if (text.isEmpty()) {
                        error = true // Muestra el error si el texto está vacío
                    } else {
                        text = "" // Si no hay error, limpia el texto
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Guardar")
            }
        }
    }

@Preview
@Composable
fun estados_a() {
        // Variable de estado para almacenar el texto ingresado por el usuario
        var text by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa toda la pantalla
                .padding(16.dp) // Margen de 16dp alrededor
        ) {
            // Campo de texto para ingresar texto
            TextField(
                value = text,
                onValueChange = { newText -> text = newText }, // Actualiza el estado al cambiar el texto
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho
                    .padding(top = 16.dp) // Margen superior de 16dp
            )

            // Muestra el texto ingresado en un fondo amarillo
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Yellow)
                    .height(40.dp)
            )

            // Botón para limpiar el texto
            Button(
                onClick = { text = "" }, // Limpia el estado del texto
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Limpiar")
            }
        }
    }
