package modelo.Objetivo

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import java.util.*

interface Objetivo {
    fun objetivoCumplido(paises: ArrayList<Pais>): Boolean
    fun setJugadorAuxiliar(actual: Jugador, auxiliar: Jugador)
}