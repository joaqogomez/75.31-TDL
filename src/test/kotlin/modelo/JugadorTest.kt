package modelo

import modelo.Batalla.Pais
import modelo.Excepciones.NoHayFuerzasRestantesError
import modelo.JuegoYJugador.Jugador
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class JugadorTest {
    @Test
    fun unJugadorPuedeOcuparUnPaisConEjercitosDerrotados() {
        val jugador1 = Jugador(1)
        jugador1.agregarFichas(1)
        val argentina = Pais("argentina")
        jugador1.ocupa(argentina) //Argentina empieza con ejercitos derrotados
        Assertions.assertNotEquals(0, argentina.getCantidadDeEjercitos())
    }

    @Test
    fun unJugadorNoPuedeOcuparUnPaisConEjercitosEnPie() {
        val jugador1 = Jugador(1)
        val jugador2 = Jugador(2) //no se derrotan sus fuerzas
        jugador1.agregarFichas(10)
        jugador2.agregarFichas(10)
        val argentina = Pais("argentina")
        val chile = Pais("chile")
        chile.agregarPaisConectado(argentina)
        argentina.agregarPaisConectado(chile)
        jugador1.ocupa(argentina)
        jugador2.ocupa(chile)
        jugador1.agregarFichasA(5, argentina)
        jugador1.ocupa(chile)
        val noExcepcion = Executable { jugador1.atacarPaisDesdeA(argentina, chile) }
        //Como no lo ocupa, lo puede atacar
        Assertions.assertDoesNotThrow(noExcepcion)
    }

    @Test
    fun siUnJugadorTrataDeOcuparUnPaisSinTenerFuerzasRestantesSeLanzaExcepcion() {
        val excepcion = Executable {
            val jugador1 = Jugador(1)
            jugador1.agregarFichas(10)
            val argentina = Pais("argentina")
            val chile = Pais("chile")
            jugador1.ocuparCon(argentina, 10)
            jugador1.ocupa(chile)
        }
        assertThrows<NoHayFuerzasRestantesError> { excepcion.execute() }
    }

    @Test
    fun unJugadorNoPierdeFichasSiLaOcupacionDeUnPaisNoEsExitosa() {
        val unJugador = Jugador(1)
        val otroJugador = Jugador(2)
        unJugador.agregarFichas(1)
        otroJugador.agregarFichas(1)
        val argentina = Pais("Argentina")
        val chile = Pais("Chile")
        unJugador.ocupa(argentina)
        otroJugador.ocupa(argentina)
        val puedeOcuparChile = Executable { otroJugador.ocupa(chile) }
        Assertions.assertDoesNotThrow(puedeOcuparChile)
    }
}