package modelo

import modelo.Batalla.Batalla
import modelo.Batalla.Ejercitos
import modelo.JuegoYJugador.Jugador
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BatallaTest {
    @Test
    fun ataqueEntrePaisesConElDefensorComoGanador() {
        val kamchatka = Ejercitos(2, Jugador(1))
        val china = Ejercitos(70, Jugador(2))
        val batalla = Batalla()
        batalla.atacar(kamchatka, china)
        Assertions.assertNotEquals(0, china.getCantidadEjercitos())
    }

    @Test
    fun ataqueEntrePaisesConElAtacanteComoGanador() {
        val kamchatka = Ejercitos(70, Jugador(1))
        val china = Ejercitos(1, Jugador(2))
        val batalla = Batalla()
        batalla.atacar(kamchatka, china)
        while (china.getCantidadEjercitos() != 0) batalla.atacar(kamchatka, china)
        Assertions.assertEquals(0, china.getCantidadEjercitos())
    }
}