package pe.edu.ulima.itlab.memoriagame.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SettingsForm(
    numRowsValue: String,
    numColsValue: String,
    onNumRowsValueChange: (String) -> Unit, //función string que no devuelve nada porque así lo pide el onValueChange
    onNumColsValueChange: (String) -> Unit,
    onGuardarClick : () -> Unit //para que llame a la función del padre que gestionará todo
) {

    Column() {

        //caja de texto con contorno
        OutlinedTextField(
            value = numRowsValue, //inicialmente el 'value' está vacío
            onValueChange = onNumRowsValueChange,  //dentro de la funcion onNumRows.. la variable de estado toma el nuevo valor de la caja de texto
            label = {
                Text(text = "Número de filas")
            }
        )

        //caja de texto
        OutlinedTextField(
            value = numColsValue,
            onValueChange = onNumColsValueChange,
            label = {
                Text(text = "Número de filas")
            }
        )

        Button(
            onClick = onGuardarClick
        ) {
            Text(text = "Guardar")
        }

    }


}