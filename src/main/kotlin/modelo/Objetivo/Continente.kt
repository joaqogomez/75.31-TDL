package modelo.Objetivo

import modelo.Batalla.Pais
import java.util.*

class Continente {
    var nombre: String
    private var paises: ArrayList<Pais> = ArrayList()
    private var cantidadDeFichasPorContinente = 0


    constructor(nombreContinente: String) {
        nombre = nombreContinente
        paises
    }

    constructor(nombreContinente: String, fichasADevolver: Int) {
        nombre = nombreContinente
        paises = ArrayList()
        cantidadDeFichasPorContinente = fichasADevolver
    }

    fun agregarPais(pais: Pais) {
        paises.add(pais)
    }

    fun cantidadPaisesQueMeConforman(): Int {
        return paises.size
    }

    fun fueConquistado(paises: ArrayList<Pais>): Boolean {
        return paises.containsAll(this.paises)
    }

    fun pertenece(pais: Pais): Boolean {
        return paises.contains(pais)
    }

    fun getCantidadDeFichasPorContinente(): Int {
        return cantidadDeFichasPorContinente
    }
}