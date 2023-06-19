package modelo

import modelo.Batalla.Pais
import modelo.Cartas.Carta
import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Juego
import modelo.JuegoYJugador.Jugador
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.util.*

class IntegracionTest {

    @Test
    fun ataqueEntreDosJugadoresYGanaElAtacante() {
        val atacante = Jugador(1)
        val defensor = Jugador(2)
        val kamchatka = Pais("Kamchatka")
        val china = Pais("China")
        kamchatka.agregarPaisConectado(china)
        china.agregarPaisConectado(kamchatka)
        atacante.agregarFichas(80)
        defensor.agregarFichas(1)
        atacante.ocuparCon(kamchatka, 80)
        defensor.ocuparCon(china, 1)
        try {
            while (true) atacante.atacarPaisDesdeA(kamchatka, china)
        } catch (excepcion: RuntimeException) {
            Assertions.assertEquals("No se puede atacar a un pais del mismo equipo", excepcion.message)
        }
    }

    @Test
    fun ataqueEntreDosJugadoresYGanaElDefensor() {
        val atacante = Jugador(1)
        val defensor = Jugador(2)
        val kamchatka = Pais("Kamchatka")
        val china = Pais("China")
        kamchatka.agregarPaisConectado(china)
        china.agregarPaisConectado(kamchatka)
        defensor.agregarFichas(80)
        atacante.agregarFichas(5)
        atacante.ocuparCon(kamchatka, 5)
        defensor.ocuparCon(china, 80)
        atacante.atacarPaisDesdeA(kamchatka, china)
        val noExcepcion = Executable { atacante.atacarPaisDesdeA(kamchatka, china) }
        //Como no lo ocupo, lo puede volver a atacar
        Assertions.assertDoesNotThrow(noExcepcion)
    }

    @Test
    fun alPerderUnaBatallaElJugadorNoPuedePedirUnaCarta() {
        val jugador1 = Jugador(1)
        val jugador2 = Jugador(2)
        val holanda = Pais("Holanda")
        val belgica = Pais("Belgica")
        val cartaChina = Carta(Pais("China"), "Globo")
        val cartas = ArrayList<Carta>()
        cartas.add(cartaChina)
        val inventario = InventarioDeJuego(cartas, ArrayList())
        holanda.agregarPaisConectado(belgica)
        belgica.agregarPaisConectado(holanda)
        jugador1.agregarFichas(10)
        jugador1.ocuparCon(holanda, 10)
        jugador2.agregarFichas(3)
        jugador2.ocuparCon(belgica, 3)
        jugador2.atacarPaisDesdeA(belgica, holanda)
        jugador2.pedirCarta(inventario)
        Assertions.assertTrue(inventario.quedanCartas())
    }

    @Test
    fun siUnJugadorConquistaUnPaisEntoncesPuedePedirUnaCarta() {
        val jugador1 = Jugador(1)
        val jugador2 = Jugador(2)
        val holanda = Pais("Holanda")
        val belgica = Pais("Belgica")
        val cartaChina = Carta(Pais("China"), "Globo")
        val cartas = ArrayList<Carta>()
        cartas.add(cartaChina)
        val inventario = InventarioDeJuego(cartas, ArrayList())
        holanda.agregarPaisConectado(belgica)
        belgica.agregarPaisConectado(holanda)
        jugador1.agregarFichas(80)
        jugador1.ocuparCon(holanda, 80)
        jugador2.agregarFichas(1)
        jugador2.ocuparCon(belgica, 1)
        try {
            while (true) jugador1.atacarPaisDesdeA(holanda, belgica)
        } catch (excepcion: RuntimeException) {
            jugador1.pedirCarta(inventario)
            Assertions.assertFalse(inventario.quedanCartas())
        }
    }

    @Test
    fun alEmpezarLosNumerosDeLosJugadoresNoEstanOrdenados() {
        val teg = Juego(6)
        val unaLista: ArrayList<Int> = ArrayList<Int>()
        for (i in 1..6) {
            unaLista.add(i)
        }
        Assertions.assertFalse(teg.obtenerOrder() == unaLista)
    }

    @Test
    fun enUnJuegoCon2JugadoresCadaUnoTiene25Paises() {
        val teg = Juego(2)
        val primero = teg.obtenerSiguiente()
        val segundo = teg.obtenerSiguiente()
        teg.iniciarJuego()
        val tienenLaMismaCantidadDePaises = primero.paisesOcupados.size == segundo.paisesOcupados.size
        val son25Paises = primero.paisesOcupados.size == 25
        Assertions.assertTrue(tienenLaMismaCantidadDePaises && son25Paises)
    }

    @Test
    fun conDosJugadoresDespuesDelUltimoVuelveElPrimero() {
        val teg = Juego(2)
        val primero = teg.obtenerSiguiente()
        teg.obtenerSiguiente()
        val deNuevoElPrimero = teg.obtenerSiguiente()
        Assertions.assertSame(primero, deNuevoElPrimero)
    }

    @Test
    fun enLaPrimeraRondaLosJugadoresPuedenPoner5Fichas() {
        val teg = Juego(2)
        teg.iniciarJuego()
        val primero = teg.obtenerSiguienteEnTurno()
        val segundo = teg.obtenerSiguienteEnTurno()
        val elPrimeroPuedePoner5Fichas = Executable {
            val unPais = primero.paisesOcupados[0]
            teg.seleccionDeJugador(primero, SeleccionJugador(unPais, unPais, 5))
        }
        val elSegundoPuedePoner5Fichas = Executable {
            val otroPais = segundo.paisesOcupados[0]
            teg.seleccionDeJugador(segundo, SeleccionJugador(otroPais, otroPais, 5))
        }
        Assertions.assertDoesNotThrow(elPrimeroPuedePoner5Fichas)
        Assertions.assertDoesNotThrow(elSegundoPuedePoner5Fichas)
    }

    @Test
    fun enLaSegundaFaseLosJugadoresPuedenPonerTresFichasMas() {
        val teg = Juego(2)
        val unPaisDelPrimero: Pais
        val unPaisDelSegundo: Pais
        teg.iniciarJuego()
        val primero = teg.obtenerSiguienteEnTurno()
        val segundo = teg.obtenerSiguienteEnTurno()
        unPaisDelPrimero = primero.paisesOcupados[0]
        unPaisDelSegundo = segundo.paisesOcupados[0]
        teg.seleccionDeJugador(primero, SeleccionJugador(unPaisDelPrimero, unPaisDelPrimero, 5))
        teg.seleccionDeJugador(segundo, SeleccionJugador(unPaisDelSegundo, unPaisDelSegundo, 5))
        val elPrimeroPuedePoner3Fichas = Executable {
            teg.obtenerSiguienteEnTurno()
            teg.seleccionDeJugador(primero, SeleccionJugador(unPaisDelPrimero, unPaisDelPrimero, 3))
        }
        val elSegundoPuedePoner3Fichas = Executable {
            teg.obtenerSiguienteEnTurno()
            teg.seleccionDeJugador(segundo, SeleccionJugador(unPaisDelSegundo, unPaisDelSegundo, 3))
        }
        Assertions.assertDoesNotThrow(elPrimeroPuedePoner3Fichas)
        Assertions.assertDoesNotThrow(elSegundoPuedePoner3Fichas)
    }

}