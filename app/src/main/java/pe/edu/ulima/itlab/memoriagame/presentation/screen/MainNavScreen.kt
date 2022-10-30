package pe.edu.ulima.itlab.memoriagame.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.ulima.itlab.memoriagame.component.screen.SettingsScreen

// Pantalla de navegación (será la raíz)
@Composable
fun MainNavScreen(
    //navController es el componente/objeto para realizar los cambios de pantalla
    navController: NavHostController = rememberNavController() //si no se pasa el valor del argumento navController, por defecto toma el remember
) {
    NavHost(
        navController = navController,
        startDestination = "settings", //el graph es para el gráfico de navegación, pero pondremos defrente las rutas de la app, por eso no está
    ) {
        //para asginar algún componente composable a la ruta "settings"
        composable("settings") {
            SettingsScreen() { numRows, numCols -> //se manda una funcion lambda como parametro
                navController.navigate("board/${numRows}/${numCols}") //navegamos hacia board
            }
        }
        composable("board/{numRows}/{numCols}",
            arguments = listOf(
                navArgument("numRows") {
                    type =
                        NavType.IntType //se define el tipo de dato del argumento {numRows} dentro del parámetro "arguments" de la función "composable"
                },
                navArgument("numCols") {
                    type = NavType.IntType
                }
            )
        ) {
            BoardScreen(
                numCols = it.arguments?.getInt("numCols")!!, // El "?" significa si it.arguments es nulo, ya no se ejecuta y numCols vale nulo ..
                numRows = it.arguments?.getInt("numRows")!! // .. El "!!" para volverlo/que devuelva un Int (eso se necesita en todos los casos), sino devolvería Int?
            )
        }


    }


}