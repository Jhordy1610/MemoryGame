package pe.edu.ulima.itlab.memoriagame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.itlab.memoriagame.model.Board
import pe.edu.ulima.itlab.memoriagame.model.BoxData

//clase Kotlin que gestiona la interfaz gráfica
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val board = Board(2,2) //alt + Enter para importar la clase Board
        board.printBoard()

        val ObjectBox = BoxData(5, false)
        board.setValue(0, 0, ObjectBox)
        println("La pos 0,0 del board es: ${board.getValue(0,0)}")


    }
}

