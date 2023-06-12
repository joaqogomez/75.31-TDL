package modelo

import modelo.Objetivo.Continente
import modelo.Parser.Parser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ParseoTest {
    @Test
    fun funcionamientoDelParser() {
        val parser = Parser()
        parser.parsearArchivo("src/main/resources/Cartas.json")
        parser.parsearArchivo("src/main/resources/Paises.json")
        parser.construirObjetos()
        Assertions.assertEquals(50, parser.getPaises().size)
        Assertions.assertEquals(50, parser.getCartas().size)
        Assertions.assertEquals(6, parser.getContinentes().size)
    }

    @Test
    fun verificoAlgunObjetoBienConstruido() {
        val parser = Parser()
        parser.parsearArchivo("src/main/resources/Cartas.json")
        parser.parsearArchivo("src/main/resources/Paises.json")
        parser.construirObjetos()
        val america : Continente = parser.getContinentes()["America del Sur"]!!
        val paises = parser.getPaises()
        Assertions.assertTrue(america.pertenece(paises["Argentina"]!!))
        Assertions.assertTrue(america.pertenece(paises["Colombia"]!!))
        Assertions.assertTrue(america.pertenece(paises["Peru"]!!))
        Assertions.assertTrue(america.pertenece(paises["Uruguay"]!!))
        Assertions.assertTrue(america.pertenece(paises["Brasil"]!!))
        Assertions.assertTrue(america.pertenece(paises["Chile"]!!))
    }
}