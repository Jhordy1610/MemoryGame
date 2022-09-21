package pe.edu.ulima.itlab.memoriagame.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pe.edu.ulima.itlab.memoriagame.model.BoxData

@Composable
fun Board(
    numRows: Int,
    numCols: Int,
    rowsData: Array<Array<BoxData>>, //el atributo 'row' de model/Board viene hasta acá, se almacena del array de array
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
                listBoxData = rowsData[index]
            )
        }

    }
}