package pe.edu.ulima.itlab.memoriagame.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class Board (numRows: Int, numCols: Int) { //cuando no se pone var o val, solo son argumentos de entrada

    //atributos
    var rows : Array<Array<MutableState<BoxData>>> //MutableState es una envoltura para el valor BoxData, cuando se cambia un atributo..
                                                   //..del objeto 'BoxData' se crea una copia o muta y eso es lo que se quiere para que el componente se regenere

    init { //codigo de inicializacion, se ejecuta luego del constructor Board
        rows = Array<Array<MutableState<BoxData>>>(numRows, { index ->
            arrayOf() //se crean filas vacias
        })

        for (i in 0..(numRows - 1)) {
            rows[i] = Array<MutableState<BoxData>>(numCols){
                mutableStateOf(BoxData(Emoji.LION, false)) //se llena cada elemento (tipo BoxData) de cada fila
            }
        }
    }

    //métodos
    fun printBoard() {
        rows.forEach {
            it.forEach {
                print("${it.value.emoji} ") //el it es la envoltura, el value es el valor BoxData que está siendo envuelto
            }
            println()
        }
    }

    /***
    fun setValue(posRow : Int,
                 posCol : Int, value : BoxData) : Unit {
        rows[posRow][posCol] = mutableStateOf(value)
    }
    ***/

    fun getValue(posRow : Int,
                 posCol : Int) : MutableState<BoxData>? {
        if (posRow >= rows.size) return null
        if (posCol >= rows[0].size) return null
        if (posRow < 0) return null
        if (posCol < 0) return null

        return rows[posRow][posCol] //retorna un elemento boxdata
    }
}