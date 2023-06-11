package modelo.Batalla

import modelo.Excepciones.NoHayFuerzasRestantesError

class EstadoEjercitosEnPie(private var cantidadFuerzas: Int) : EstadoEjercitos {

    override fun evaluarFuerzasRestantes(): EstadoEjercitos {
        return if (cantidadFuerzas <= 0) EstadoEjercitosDerrotados() else this
    }

    override fun getCantidadFuerzas(): Int {
        return cantidadFuerzas
    }

    override fun agregarFuerzas(numeroDeFuerzas: Int): EstadoEjercitos {
        cantidadFuerzas += numeroDeFuerzas
        return this
    }

    override fun restarFuerzas(numeroFuerzas: Int): EstadoEjercitos {
        if (cantidadFuerzas < numeroFuerzas) {
            throw NoHayFuerzasRestantesError()
        }
        cantidadFuerzas -= numeroFuerzas
        return evaluarFuerzasRestantes()
    }

    override fun estanDerrotados(): Boolean {
        return false
    }

    override fun equals(otro: Any?): Boolean {
        if (otro === this) return true else if (otro == null || otro::class != EstadoEjercitosEnPie::class) return false
        val otroEnPie = otro as EstadoEjercitosEnPie
        return otroEnPie.cantidadFuerzas == cantidadFuerzas
    }
}