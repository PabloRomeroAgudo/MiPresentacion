package com.example.mipresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mipresentacion.ui.theme.MiPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiPresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Aplicacion()
                }
            }
        }
    }
}

@Composable
fun Aplicacion(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    )
    {
        Row (modifier = modifier
            .weight(1f)
            .background(Color(0, 70, 71, 255))
        ){
            Fotografia(painterResource(R.drawable.fotoperfil2),
                modifier.weight(0.8f))
            InfoPersonal(modifier.weight(1.2f))
        }
        Row (modifier = modifier
            .weight(2f)
        ){
            InfoExtra()
        }
    }
}

@Composable
fun Fotografia(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 48.dp)
    )
}

@Composable
fun InfoPersonal(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxHeight()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Pablo Romero Agudo",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,

        )
        Text(
            text = "Programador Junior",
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp),
            color = Color.White
        )
        InfoAdicional()

    }
}

@Composable
fun InfoAdicional() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Icon (
                Icons.Default.Phone,
                contentDescription = null,
                tint = Color.White

            )
            Text(text = " +34 123456789", color = Color.White)
        }

        Row (
            modifier = Modifier.padding(top= 5.dp, bottom= 5.dp)
        ){
            Icon (
                Icons.Default.Person,
                contentDescription = null,
                tint = Color.White
            )
            Text(text = " @pablo_03", color = Color.White )
        }

        Row {
            Icon (
                Icons.Default.Email,
                contentDescription = null,
                tint = Color.White
            )
        Text(text = " correo@gmail.com", color = Color.White)
        }
    }
}

@Composable
fun InfoExtra() {
    var introduccion by remember { mutableStateOf("Soy un programador entusiasta, joven y con ganas de aprender. Desde pequeño me ha gustado la tecnología y me encanta estar horas programando delante del ordenador.") }
    var idioma by remember { mutableStateOf("English") }
    var trabajos by remember { mutableStateOf("Proyectos Realizados:") }
    var github by remember { mutableStateOf("Mi codigo!") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(start = 30.dp, top = 30.dp, end = 30.dp, bottom = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = introduccion,
                color = Color(0, 70, 71, 255),
                modifier = Modifier
                    .height(125.dp)
            )
            Button(onClick = {
                    if (idioma == "English") {
                        introduccion = "I am an enthusiastic programmer, young and eager to learn. Since I was a child I have loved technology and I love to spend hours programming in front of the computer."
                        idioma = "Español"
                        trabajos = "Projects Completed"
                        github = "My code!"
                    } else {
                        introduccion = "Soy un programador entusiasta, joven y con ganas de aprender. Desde pequeño me ha gustado la tecnología y me encanta estar horas programando delante del ordenador."
                        idioma = "English"
                        trabajos = "Proyectos Realizados:"
                        github = "Mi codigo!"
                    }
                },
                modifier = Modifier.width(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0, 70, 71, 255)),
                border = BorderStroke(1.dp, Color(0, 70, 71, 255))
            ) {
                Text(text = idioma)
            }
        }
        Proyectos(trabajos, github)
    }
}

@Composable
fun Proyectos(trabajos : String, github : String) {
    Column(
        modifier = Modifier
            .background(Color(0, 70, 71, 255))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = trabajos,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            color = Color.White
        )

        Row (
            modifier = Modifier.padding(bottom = 20.dp, start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val primerproyecto = painterResource(R.drawable.primerproyecto)
            val segundoproyecto = painterResource(R.drawable.segundoproyecto)

            Image(
                painter = primerproyecto,
                contentDescription = null,
                modifier = Modifier.weight(1f)
            )
            Image(painter = segundoproyecto,
                contentDescription = null,
                modifier = Modifier.weight(1f)
            )
        }
        val localUriHandler = LocalUriHandler.current

        Button(onClick = { localUriHandler.openUri("https://github.com/PabloRomeroAgudo/MiPresentacion") },
            modifier = Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0, 70, 71, 255),
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.White)
        ) {
            Text(text = github)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiPresentacionTheme {
        Aplicacion()
    }
}
