import javafx.application.Application
import modelo.Parser.Parser
import vista.Tablero

fun main() {

    val parser = Parser()
    parser.parsearArchivo("src/main/resources/Cartas.json")
    parser.parsearArchivo("src/main/resources/Paises.json")
    parser.parsearArchivo("src/main/resources/Objetivos.json")
    parser.construirObjetos()
    Application.launch(Tablero::class.java)
}