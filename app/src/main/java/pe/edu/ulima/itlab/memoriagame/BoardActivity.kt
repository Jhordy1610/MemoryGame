package pe.edu.ulima.itlab.memoriagame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.ulima.itlab.memoriagame.screen.BoardScreen
import pe.edu.ulima.itlab.memoriagame.ui.theme.MemoriaGameTheme

class BoardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Texto()
            BoardScreen(4, 6)
        }
    }
}

@Composable
fun Texto() {
    /***
    Row(content = {
    Text(text = "Hola Android Compose")
    Text(text = "Hola Android Compose")
    })
     ***/
    Column(
        modifier = Modifier
            .fillMaxWidth() //la columna ocupa el ancho y alto máximo
            .fillMaxHeight(), //encadenamos el modificador
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Hola Android Compose"
        )
        Text(
            text = "Hola Android Compose",
            modifier = Modifier.weight(1f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth() //la fila ocupa todo el ancho
                .weight(1f)
        ) {

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    //.fillMaxWidth(0.5f) //ocupa la mitad del ancho
                    .weight(1f)
            ) {
                Text(text = "Boton1")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    //.fillMaxWidth() //del espacio restante, ocupa todo
                    .weight(1f)
            ) {
                Text(text = "Boton2")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShowTexto() {
    Texto()
}












