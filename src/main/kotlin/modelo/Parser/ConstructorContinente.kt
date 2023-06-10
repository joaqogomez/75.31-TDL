package modelo.Parser

import modelo.Continente
import modelo.Batalla.Pais
import java.util.*
import java.util.regex.Pattern

class ConstructorContinente {

    private val sieteFichas = 7
    private val cincoFichas = 5
    private val tresFichas = 3
    private val dosFichas = 2
    private var continentes: HashMap<String, Continente> = HashMap<String, Continente>()

    fun construirContinente(continente: HashMap<String, String>, paises: HashMap<String, Pais>) {
        for(key in continente.keys){
            continentes.put(key, crearContinente(key))
        }
        val continenteKeys: Collection<String> = continente.keys
        for (cont in continenteKeys) {
            val paisesContinente = continente[cont]
            val paisesDelContinente: Array<String> = Pattern.compile(",").split(paisesContinente)
            for (paisCont in paisesDelContinente) {
                val paisActual: Pais? = paises[paisCont]
                val continenteActual: Continente? = continentes[cont]
                continenteActual!!.agregarPais(paisActual!!)
            }
        }
    }

    private fun crearContinente(nombre: String): Continente {
        val continente: Continente
        when (nombre) {
            "Asia" -> continente = Continente(nombre, sieteFichas)
            "Europa", "America del Norte" -> continente = Continente(nombre, cincoFichas)
            "America del Sur", "Africa" -> continente = Continente(nombre, tresFichas)
            else -> continente = Continente(nombre, dosFichas)
        }
        return continente
    }

    fun getContinentes(): HashMap<String, Continente>{
        return continentes
    }

}
