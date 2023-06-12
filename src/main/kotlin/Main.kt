import modelo.Parser.Constructor
import modelo.Parser.Parser

fun main(args: Array<String>) {

    val parser = Parser()
    parser.parsearArchivo("src/main/resources/Cartas.json")
    parser.parsearArchivo("src/main/resources/Paises.json")
    parser.parsearArchivo("src/main/resources/Objetivos.json")
    parser.construirObjetos()
    print(parser.getPaises().size)



}