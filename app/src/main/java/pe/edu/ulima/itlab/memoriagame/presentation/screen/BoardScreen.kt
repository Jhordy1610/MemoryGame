package pe.edu.ulima.itlab.memoriagame.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.ulima.itlab.memoriagame.presentation.component.Board
import pe.edu.ulima.itlab.memoriagame.presentation.component.Header

@Composable
fun BoardScreen(
    numCols: Int,
    numRows: Int
) {

    // Variable de estado 'board' : este sería el componente padre, contiene todo el tablero 'Board' y lo regenera por cada cambio de un sub-componente
    val board = remember {
        mutableStateOf(pe.edu.ulima.itlab.memoriagame.model.Board(
            numRows = numRows,
            numCols = numCols
        ))
    }

    //objeto boxOnClick de tipo función
    val boxOnClick: (Int, Int) -> Unit = { row, col -> //los argumentos de entrada se vuelven a poner acá
        Log.i("BoardScreen","$row, $col")
        board.value.rows[row][col].value =
            board.value.rows[row][col].value.copy(isShown = true) //acá se clona el objeto BoxData, entonces el Board se regenera al ser un
                                                                  // mutableStateOf (se ejecuta de nuevo y envía nueva data a sus hijos)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        Board(
            numRows = numRows,
            numCols = numCols,
            rowsData = board.value.rows, //para pasarle un atributo de otra clase, de tipo : Array<Array<BoxData>>
            boxOnClick
        )
    }
}

/***
@Composable
@Preview(showBackground = true)
fun showBoardScreen() {
    BoardScreen()
}
***/