package modelo.Cartas

import modelo.Excepciones.NoQuedanCartasError
import modelo.JuegoYJugador.Jugador
import java.util.*

class Mazo(cartas: ArrayList<Carta>) {

    val cartas: ArrayList<Carta>

    private fun asociarmeLasCartas(cartas: ArrayList<Carta>) {
        for (carta in cartas) {
            carta.asociarAlMazo(this)
        }
    }

    fun repartirCarta(unJugador: Jugador) {
        sePuedeRepartirCarta()
        unJugador.recibirCarta(retirarPrimera())
    }

    private fun sePuedeRepartirCarta() {
        if (!tengoCartasRestantes()) {
            throw NoQuedanCartasError()
        }
    }

    private fun tengoCartasRestantes(): Boolean {
        return !cartas.isEmpty()
    }

    private fun retirarPrimera(): Carta {
        return cartas.removeAt(0)
    }

    fun vuelveAlMazo(carta: Carta) {
        cartas.add(carta)
    }

    fun quedanCartas(): Boolean {
        return !cartas.isEmpty()
    }

    fun repartirCarta(manoDeCartas: ManoDeCartas) {
        sePuedeRepartirCarta()
        manoDeCartas.recibirCarta(retirarPrimera())
    }

    init {
        asociarmeLasCartas(cartas)
        this.cartas = cartas
    }
}