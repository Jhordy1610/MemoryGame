package pe.edu.ulima.itlab.memoriagame.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Board(
    numRows: Int,
    numCols: Int,
    boxOnClick: (Int, Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    )
    {
        //el map recorre toda la lista y devuelve 8 BoardRow
        (0 until numRows).mapIndexed { index, _ ->
            BoardRow(
                row = index,
                numCols = numCols,
                modifier = Modifier.weight(1f), //este modifier lo hará responsive por el lado 'filas'
                onClick = boxOnClick,
            )
        }

    }
}