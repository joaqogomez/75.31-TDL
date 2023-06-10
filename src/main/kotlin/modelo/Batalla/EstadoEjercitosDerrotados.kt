package modelo.Batalla

import modelo.Excepciones.EjercitosDerrotadosError
import modelo.Excepciones.NoHayFuerzasRestantesError

class EstadoEjercitosDerrotados : EstadoEjercitos {
    override fun evaluarFuerzasRestantes(): EstadoEjercitos {
        return this
    }

    override val cantidadFuerzas: Int
        get() = 0

    override fun agregarFuerzas(numeroDeFuerzas: Int): EstadoEjercitos {
        throw EjercitosDerrotadosError()
    }

    override fun restarFuerzas(numeroFuerzas: Int): EstadoEjercitos {
        throw NoHayFuerzasRestantesError()
    }

    override fun estanDerrotados(): Boolean {
        return true
    }

    override fun equals(otro: Any?): Boolean {
        return otro!!.javaClass == EstadoEjercitosDerrotados::class.java
    }
}