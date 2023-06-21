package modelo.Objetivo

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import java.util.*

class ObjetivoJugador(var general: Objetivo,var secreto: Objetivo) : Objetivo {

    override fun objetivoCumplido(paises: ArrayList<Pais>): Boolean {
        return general.objetivoCumplido(paises) || secreto.objetivoCumplido(paises)
    }

    override fun setJugadorAuxiliar(actual: Jugador, auxiliar: Jugador) {
        secreto.setJugadorAuxiliar(actual, auxiliar)
    }

    override fun tipo(): String {
        return "jugador"
    }

    override fun texto(): String {
        return "General: " + general.texto() + "\n Secreto: " + secreto.texto()
    }


}
