package pe.edu.ulima.itlab.memoriagame.presentation.component

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.ulima.itlab.memoriagame.model.BoxData

@Composable
fun BoardBox(
    row: Int, //'row' y 'col' serán usado en 'onClick' que contiene la función
    col: Int,
    modifier: Modifier,
    boxData: BoxData,
    onClick: (Int, Int) -> Unit
) {
    //var mostrarEmoji = false //aún no es variable de estado

    //Variable de estado (MutableState<Boolean>)
    var mostrarEmoji = remember {
        mutableStateOf(false) //empieza con false
    }

    Button(
        onClick = {
            mostrarEmoji.value = true
            //onClick(row, col) //el boxOnClick se pasa por parámetro sucesivamente para no importarlo y usar el nombre del parámetro de acá
            //boxOnClick(row, col)
            //Log.i("BoardBox", "$row, $col")
        },
        modifier = modifier.padding( //al aplicar este modifier lo hacemos responsive por el lado 'columnas' de cada fila
            start = 8.dp,
            end = 8.dp
        )
    ) {
        if (!mostrarEmoji.value) { //cuando es false
            Text(text = "PM")
        } else {
            Text(text = String( //cuando es true
                Character.toChars(
                    boxData.emoji.emojiValue
                )
            )
            )
        }
    }

}