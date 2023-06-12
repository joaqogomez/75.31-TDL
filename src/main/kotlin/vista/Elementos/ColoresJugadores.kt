package edu.fiuba.algo3.vista.Elementos

class ColoresJugadores {
    private val colores: HashMap<Int?, String?>?

    init {
        colores = HashMap()
        setUpColores()
    }

    private fun setUpColores() {
        val coloresJugadores =
            arrayOf<String?>("#cc00ff", "#0077bb", "#cc3311", "#ee7733", "#009988", "#ee3377", "#000000")
        for (i in 0..6) {
            colores[i] = coloresJugadores[i]
        }
    }

    fun getColor(numeroJugador: Int?): String? {
        return colores.get(numeroJugador)
    }
}