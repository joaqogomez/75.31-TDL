package modelo.Objetivo

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import java.util.*

class ObjetivoGeneral(var cantidadDePaisesAConquistar: Int) : Objetivo {

    override fun objetivoCumplido(paises: ArrayList<Pais>): Boolean {
        return paises.size >= cantidadDePaisesAConquistar
    }

    override fun setJugadorAuxiliar(actual: Jugador, auxiliar: Jugador) {}

}
