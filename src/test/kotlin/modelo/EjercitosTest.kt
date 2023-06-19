package modelo

import modelo.Batalla.Ejercitos
import modelo.Excepciones.NoHayFuerzasRestantesError
import modelo.JuegoYJugador.Jugador
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class EjercitosTest {
    @Test
    fun creoEjercitoYDebeTenerCero() {
        val ejercito = Ejercitos()
        Assertions.assertEquals(0, ejercito.getCantidadEjercitos())
    }

    @Test
    fun creoEjercitoYAgregoEjercito() {
        val ejercito = Ejercitos(1, Jugador(1))
        ejercito.agregarEjercitos(4)
        Assertions.assertEquals(5, ejercito.getCantidadEjercitos())
    }

    @Test
    fun creoEjercitoYAgregoEjercitoYResto() {
        val ejercito = Ejercitos(1, Jugador(1))
        ejercito.agregarEjercitos(5)
        ejercito.restarEjercitos(3)
        Assertions.assertEquals(3, ejercito.getCantidadEjercitos())
    }

    @Test
    fun creoEjercitoYAgregoEjercitoYLosEliminoATodosEntoncesFueDerrotado() {
        val ejercito = Ejercitos(1, Jugador(1))
        ejercito.agregarEjercitos(4)
        ejercito.restarEjercitos(5)
        Assertions.assertEquals(0, ejercito.getCantidadEjercitos())
    }

    @Test
    fun siSeTrataDeRestarEjercitosDeUnosDerrotadosSeLanzaExcepcion() {
        val excepcion = Executable {
            val ejercitos = Ejercitos()
            ejercitos.restarEjercitos(1)
        }
        assertThrows<NoHayFuerzasRestantesError> { excepcion.execute() }
    }

    @Test
    fun siSeTrataDeRestarMasFuerzasDeLasQueHayEntoncesSeLanzaExcepcion() {
        val excepcion = Executable {
            val ejercitos = Ejercitos(2, Jugador(1))
            ejercitos.restarEjercitos(3)
        }
        assertThrows<NoHayFuerzasRestantesError> { excepcion.execute() }
    }
}