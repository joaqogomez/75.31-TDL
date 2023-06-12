package modelo

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import modelo.Parser.Parser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.stream.Collectors

class ColocacionTest {
    @Test
    fun dosJugadoresColocanEjercitos() {
        val jugadorUno = Jugador(1)
        val jugadorDos = Jugador(2)
        jugadorUno.agregarFichas(3)
        jugadorDos.agregarFichas(3)
        val china = Pais("china")
        val argentina = Pais("argentina")
        jugadorUno.ocuparCon(china, 2)
        jugadorDos.ocuparCon(argentina, 3)
        Assertions.assertEquals(china.getCantidadDeEjercitos(), 2)
        Assertions.assertEquals(argentina.getCantidadDeEjercitos(), 3)
    }

    @Test
    fun tresJugadoresColocanEjercitos() {
        val jugadorUno = Jugador(1)
        val jugadorDos = Jugador(2)
        val jugadorTres = Jugador(3)
        jugadorUno.agregarFichas(15)
        jugadorDos.agregarFichas(15)
        jugadorTres.agregarFichas(15)
        var jugadores = HashMap<Int, Jugador>()
        jugadores.put(1, jugadorUno)
        jugadores.put(2, jugadorDos)
        jugadores.put(3, jugadorTres)
        val parser = Parser(jugadores)
        parser.parsearArchivo("src/main/resources/Cartas.json")
        parser.parsearArchivo("src/main/resources/Paises.json")
        parser.construirObjetos()
        val paises = parser.getPaises()
        val continentes = parser.getContinentes()
        val francia = Pais("Francia")
        val argentina = Pais("Argentina")
        val asia = continentes["Asia"]
        val paisesDeAsia = ArrayList(paises.values).stream().filter { pais: Pais -> asia!!.pertenece(pais) }
            .collect(Collectors.toList())
        Assertions.assertEquals(asia!!.cantidadPaisesQueMeConforman(), 15)

        Assertions.assertEquals(asia!!.getCantidadDeFichasPorContinente(), 7)
        for (pais in paisesDeAsia) {
            jugadorDos.ocupasteA(pais)
        }
        jugadorUno.ocuparCon(francia, 2)
        jugadorTres.ocuparCon(argentina, 3)
        Assertions.assertTrue(asia.fueConquistado(jugadorDos.paisesOcupados))
    }
}