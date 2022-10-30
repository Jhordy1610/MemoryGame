package pe.edu.ulima.itlab.memoriagame.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import pe.edu.ulima.itlab.memoriagame.presentation.component.Header
import pe.edu.ulima.itlab.memoriagame.presentation.component.SettingsForm

@Composable
fun SettingsScreen(
    onNavigateToBoard: (numRows: Int, numCols: Int) -> Unit
) {

    val numRows = remember() {
        mutableStateOf("")
    }

    val numCols = remember() {
        mutableStateOf("")
    }

    Column {
        Header()
        SettingsForm(
            numRowsValue = numRows.value,
            numColsValue = numCols.value,
            onNumRowsValueChange = {
                numRows.value = it //la variable de estado toma el nuevo valor de la caja de texto
            },
            onNumColsValueChange = {
                numCols.value = it
            },
            onGuardarClick = {
                // Cambiar a nueva pantalla
                if (numRows.value != "" && numCols.value != "") { //si no se ingresa ni un valor y le damos a guardar, daria error, por eso validamos
                    onNavigateToBoard(
                        numRows.value.toInt(), //numRows.value es un string, convertimos a int
                        numCols.value.toInt()
                    )
                }
            }
        )
    }


}