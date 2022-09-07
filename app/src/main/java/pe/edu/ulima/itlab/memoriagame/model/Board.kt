package pe.edu.ulima.itlab.memoriagame.model

class Board (numRows: Int, numCols: Int) { //cuando no se pone var o val, solo son argumentos de entrada

    //atributos
    var rows : Array<Array<BoxData>>

    init { //codigo de inicializacion, se ejecuta luego del constructor Board
        rows = Array<Array<BoxData>>(numRows, { index ->
            arrayOf() //se crean filas vacias
        })

        for (i in 0..(numRows - 1)) {
            rows[i] = Array<BoxData>(numCols){
                BoxData(20, false) //se llena cada elemento (tipo BoxData) de cada fila con el valor 20
            }
        }
    }

    //métodos
    fun printBoard() {
        rows.forEach {
            it.forEach {
                print("${it.emoji} ")
            }
            println()
        }
    }

    fun setValue(posRow : Int,
                 posCol : Int, value : BoxData) : Unit {
        rows[posRow][posCol] = value
    }

    fun getValue(posRow : Int,
                 posCol : Int) : BoxData? {
        if (posRow >= rows.size) return null
        if (posCol >= rows[0].size) return null
        if (posRow < 0) return null
        if (posCol < 0) return null

        return rows[posRow][posCol]
    }
}