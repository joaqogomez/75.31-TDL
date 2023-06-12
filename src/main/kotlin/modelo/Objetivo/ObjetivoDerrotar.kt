package modelo.Objetivo

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import java.util.*


class ObjetivoDerrotar(var jugador: Jugador) : Objetivo {

    override fun objetivoCumplido(paises: ArrayList<Pais>): Boolean {
        return this.jugador.fueDerrotado()
    }

    override fun setJugadorAuxiliar(actual: Jugador, auxiliar: Jugador) {
        if (jugador == null || jugador.equals(actual)) jugador = auxiliar
    }
}
