package modelo.Objetivo

import modelo.Batalla.Pais
import java.util.*

class ObjetivoConquistar(var primario: Continente,var secundario: Continente,var cantidadAConquistarSecundario : Int) : Objetivo {

    private fun contadorDePaisesSecundarios(paises: ArrayList<Pais>): Int {
        var contador = 0
        for (pais in paises) {
            if (secundario.pertenece(pais)) contador += 1
        }
        return contador
    }

    override fun objetivoCumplido(paises: ArrayList<Pais>): Boolean {
        val cantidadPaisesSecundarios = contadorDePaisesSecundarios(paises)
        return primario.fueConquistado(paises) && cantidadPaisesSecundarios >= this.cantidadAConquistarSecundario
    }
}