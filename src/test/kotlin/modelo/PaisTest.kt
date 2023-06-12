package modelo

import modelo.Batalla.Pais
import modelo.Excepciones.AtaqueNoPermitidoError
import modelo.JuegoYJugador.Jugador
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class PaisTest {
    @Test
    fun creoUnPaisYVerificoSuNombre() {
        val argentina = Pais("Argentina")
        Assertions.assertEquals("Argentina", argentina.getNombreDelPais())
    }

    @Test
    fun creoUnPaisYAgregoEjercitos() {
        val jugador1 = Jugador(1)
        jugador1.agregarFichas(6)
        val argentina = Pais("Argentina")
        jugador1.ocupa(argentina)
        argentina.agregarEjercito(5)
        Assertions.assertEquals(6, argentina.getCantidadDeEjercitos())
    }

    @Test
    fun creoDosPaisesLimitrofesYVericoQueSePuedenAtacar() {
        val excepcion = Executable {
            val jugador1 = Jugador(1)
            val jugador2 = Jugador(2)
            jugador1.agregarFichas(1)
            jugador2.agregarFichas(1)
            val argentina = Pais("Argentina")
            val chile = Pais("Chile")
            jugador1.ocupa(argentina)
            jugador2.ocupa(chile)
            chile.agregarEjercito(2)
            argentina.agregarEjercito(2)
            argentina.agregarPaisConectado(chile)
            chile.agregarPaisConectado(argentina)
            chile.atacarA(argentina)
        }
        Assertions.assertDoesNotThrow(excepcion)
    }

    @Test
    fun creoDosPaisesQuePertenezcanAlMismoJugadorYVerificoQueNoSePuedenAtacar() {
        val excepcion = Executable {
            val jugador1 = Jugador(1)
            jugador1.agregarFichas(2)
            val argentina = Pais("Argentina")
            val chile = Pais("Chile")
            jugador1.ocupa(argentina)
            jugador1.ocupa(chile)
            chile.atacarA(argentina)
        }
        assertThrows<AtaqueNoPermitidoError> { excepcion.execute() }
    }

    @Test
    fun creoDosPaisesQueNoPertenezcanAlMismoJugadorYVerificoQueSePuedenAtacar() {
        val excepcion = Executable {
            val jugador1 = Jugador(1)
            val jugador2 = Jugador(2)
            jugador1.agregarFichas(3)
            jugador2.agregarFichas(3)
            val argentina = Pais("Argentina")
            val chile = Pais("Chile")
            argentina.agregarPaisConectado(chile)
            chile.agregarPaisConectado(argentina)
            jugador1.ocuparCon(chile, 3)
            jugador2.ocuparCon(argentina, 3)
            chile.atacarA(argentina)
        }
        Assertions.assertDoesNotThrow(excepcion)
    }
}