package modelo

import modelo.Batalla.Pais
import java.util.*

class Continente {
    var nombre: String
    private var paises: ArrayList<Pais>
    var cantidadDeFichasPorContinente = 0

    constructor(nombreContinente: String) {
        nombre = nombreContinente
        paises = ArrayList()
    }

    constructor(nombreContinente: String, fichasADevolver: Int) {
        nombre = nombreContinente
        paises = ArrayList()
        cantidadDeFichasPorContinente = fichasADevolver
    }

    fun agregarPais(pais: Pais) {
        paises.add(pais)
    }
}