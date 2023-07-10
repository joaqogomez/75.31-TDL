package modelo.Batalla

import java.util.*

class Dado {
    private val maximasTiradas = 3
    private val cantidadNumerosDado = 6

    fun tirarDado(cantidad: Int): ArrayList<Int> {
        val numeroRandom = Random()
        val resultado = ArrayList<Int>()
        if (cantidad >= maximasTiradas) {
            for (i in 1 .. maximasTiradas) {
                resultado.add(numeroRandom.nextInt(cantidadNumerosDado) + 1)
            }
        } else {
            for (i in 1 .. cantidad) {
                resultado.add(numeroRandom.nextInt(cantidadNumerosDado) + 1)
            }
        }
        resultado.sortedDescending()
        return resultado
    }
}