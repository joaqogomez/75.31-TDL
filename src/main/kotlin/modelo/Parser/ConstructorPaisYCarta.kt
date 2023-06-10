package modelo.Parser

import com.sun.tools.javac.util.Pair
import modelo.Carta
import modelo.Pais
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.Collection


class ConstructorPaisYCarta {

    private var mazoDeCartas: ArrayList<Carta> = ArrayList<Carta>()
    private var paises: HashMap<String, Pais> = HashMap<String, Pais>()

    fun construirPaisesYCartas(
        cartaPaisHash: HashMap<String, String>, fronteras: HashMap<String, String>,
        coordenadas: HashMap<String, Pair<Int, Int>>
    ) {

        for(key in cartaPaisHash.keys){
            paises.put(key, Pais(key))
        }

        val paisesValues: Collection<String?> = cartaPaisHash.keys
        for (pais in paisesValues) {
            val stringFrontera: String = fronteras[pais!!]!!
            val paisesFrontera: Array<String> = Pattern.compile(",").split(stringFrontera)
            val paisActual = paises[pais!!]!!
            for (front in paisesFrontera) {
                paisActual.agregarPaisConectado(paises[front]!!)
            }
            paisActual.setCoordenadas(coordenadas[paisActual.getNombreDelPais()]!!)
        }

        for(key in cartaPaisHash.keys){
            mazoDeCartas.add(Carta(paises[key]!!, cartaPaisHash[key]!!))
        }

    }

    fun getPaises(): HashMap<String, Pais> {
        return paises
    }

    fun getCartas(): ArrayList<Carta> {
        return mazoDeCartas
    }
}
