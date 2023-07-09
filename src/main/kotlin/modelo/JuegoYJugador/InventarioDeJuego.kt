package modelo.JuegoYJugador

import modelo.Batalla.Pais
import modelo.Cartas.Carta
import modelo.Cartas.ManoDeCartas
import modelo.Cartas.Mazo
import modelo.Objetivo.Continente
import java.util.*

class InventarioDeJuego(mazoDeCartas: ArrayList<Carta>, continentes: ArrayList<Continente>) {

    var mazoDeCartas: Mazo = Mazo(mazoDeCartas)
    var continentes: ArrayList<Continente> = continentes
    lateinit var paises: List<Pais>

    fun ejercitosPorContinentesConquistados(paisesOcupados: ArrayList<Pais>): Int {
        var ejercitosTotal = 0
        for (continente in continentes) {
            if (continente.fueConquistado(paisesOcupados)) {
                ejercitosTotal += continente.getCantidadDeFichasPorContinente()
            }
        }
        return ejercitosTotal
    }

    fun repartirCarta(jugador1: Jugador) {
        mazoDeCartas.repartirCarta(jugador1)
    }

    fun quedanCartas(): Boolean {
        return mazoDeCartas.quedanCartas()
    }

    fun repartirCarta(mano: ManoDeCartas) {
        mazoDeCartas.repartirCarta(mano)
    }

    fun setPaises(paises: ArrayList<Pais>) {
        this.paises = paises
    }

    fun cantidadDePaises(): Int {
        return paises.size
    }
}