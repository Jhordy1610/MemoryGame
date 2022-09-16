package pe.edu.ulima.itlab.memoriagame.presentation.component

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoardBox(
    row: Int, //'row' y 'col' serán usado en 'onClick' que contiene la función
    col: Int,
    modifier: Modifier,
    onClick: (Int, Int) -> Unit
) {
    Button(
        onClick = {
            onClick(row, col) //el boxOnClick se pasa por parámetro sucesivamente para no importarlo y usar el nombre del parámetro de acá
            //boxOnClick(row, col)
            //Log.i("BoardBox", "$row, $col")
        },
        modifier = modifier.padding( //al aplicar este modifier lo hacemos responsive por el lado 'columnas' de cada fila
            start = 8.dp,
            end = 8.dp
        )
    ) {
        Text(text = "PM")
    }

}