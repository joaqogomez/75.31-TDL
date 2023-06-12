package modelo.Objetivo

import modelo.Batalla.Pais
import java.util.*

class ObjetivoJugador(var general: Objetivo,var secreto: Objetivo) : Objetivo {

    override fun objetivoCumplido(paises: ArrayList<Pais>): Boolean {
        return general.objetivoCumplido(paises) || secreto.objetivoCumplido(paises)
    }

}
