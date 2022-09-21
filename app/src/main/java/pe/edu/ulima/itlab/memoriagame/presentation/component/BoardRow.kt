package pe.edu.ulima.itlab.memoriagame.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.ulima.itlab.memoriagame.model.BoxData

@Composable
fun BoardRow(
    row: Int,
    numCols: Int,
    modifier: Modifier,
    listBoxData : Array<BoxData>,
    onClick: (Int, Int) -> Unit
) {
    Row(
        modifier = modifier //al aplicar este modifier lo hacemos responsive por el lado 'filas'
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
    ) {
        (0 until numCols).mapIndexed { index, _ -> //el index es el índice del elemento, se pone underline porque el elemento que va ahí no se utilizará
            BoardBox(
                modifier = modifier //este modifier lo hará responsive por el lado 'columnas'
                    .fillMaxHeight(),
                onClick = onClick,
                row = row,
                col = index,
                boxData = listBoxData[index]
            )
        }
    }
}

