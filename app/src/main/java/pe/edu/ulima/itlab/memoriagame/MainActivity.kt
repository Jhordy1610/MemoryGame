package pe.edu.ulima.itlab.memoriagame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import pe.edu.ulima.itlab.memoriagame.model.Board
import pe.edu.ulima.itlab.memoriagame.model.BoxData
import pe.edu.ulima.itlab.memoriagame.model.Emoji

//clase Kotlin que gestiona la interfaz gráfica
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val board = Board(2,2) //alt + Enter para importar la clase Board
        board.printBoard()

        /***
        val emojiChange = Emoji("&#1F38E") //ERROR, emoji es un enum class
        val ObjectBox = BoxData(emojiChange, false)
        board.setValue(0, 0, ObjectBox)
        println("La pos 0,0 del board es: ${board.getValue(0,0)}")
        ***/

        val but0_0 = findViewById<Button>(R.id.but0_0)
        val but0_1 = findViewById<Button>(R.id.but0_1)
        val but1_0 = findViewById<Button>(R.id.but1_0)
        val but1_1 = findViewById<Button>(R.id.but1_1)

        /***
        but0_0.setOnClickListener{ view -> //view representa al componente, o sea, al boton
            // Se va a ejecutar al hacer click
            val viewIdStr = view.resources.getResourceName(view.id) //view.id está 'definido' como string, pero en realidad es un entero, la clase R lo crea así
                .split("/")[1]
            Log.i("MainActivity", "Se hizo click: ${viewIdStr}")
        }
        ***/

        /*** Mejor es tener 'un objeto de tipo función' para re-utilizarla en todos los botones ***/
        val boxOnClickListener : (view : View) -> Unit = { view ->
            // Se va a ejecutar al hacer click
            val viewIdStr =
                view.resources.getResourceName(view.id)
                    .split("/")[1]
            val cad = viewIdStr.substring(3) //desde la pos 3 en adelante
            val arrCoordenadas = cad.split("_")
            val row = arrCoordenadas[0].toInt()
            val col = arrCoordenadas[1].toInt()

            val data = board.getValue(row, col)
            if (data != null) {
                (view as Button).text = //casteamos a la clase hijo 'button' porque 'view' es un View genérico y todo lo demás se está ocultando
                    String(Character.toChars(data.emoji.emojiValue))
            }

            Log.i("MainActivity", "Se hizo click: ${viewIdStr}")
        }

        but0_0.setOnClickListener(boxOnClickListener)
        but0_1.setOnClickListener(boxOnClickListener)
        but1_0.setOnClickListener(boxOnClickListener)
        but1_1.setOnClickListener(boxOnClickListener)
    }
}

