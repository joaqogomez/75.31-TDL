package modelo.Batalla

import modelo.Excepciones.MovimientoDeEjercitoError
import modelo.JuegoYJugador.Jugador


open class Ejercitos {
    private var comandante: Jugador
    protected var condicionActual: EstadoEjercitos

    constructor() {
        comandante = Jugador(0)
        condicionActual = EstadoEjercitosDerrotados()
    }

    constructor(numeroFuerzas: Int, comandante: Jugador) {
        this.comandante = comandante
        condicionActual = EstadoEjercitosEnPie(numeroFuerzas)
    }

    fun getCantidadEjercitos(): Int {
        return condicionActual.getCantidadFuerzas()
    }
    fun agregarEjercitos(cantidad: Int) {
        condicionActual.agregarFuerzas(cantidad)
    }

    fun generarDivision(cantidad: Int): Ejercitos {
        return confirmarNuevaDivisionDe(cantidad)
    }

    fun restarEjercitos(cantidad: Int) {
        condicionActual = condicionActual.restarFuerzas(cantidad)
    }

    fun sonAliadosDe(ejercitos: Ejercitos): Boolean {
        return comandante == ejercitos.comandante
    }

    open fun disputarDominioDe(pais: Pais, otrosEjercitos: Ejercitos): Ejercitos {
        if (fueDerrotado()) {
            comandante.perdisteA(pais)
            otrosEjercitos.comandante.ocupasteA(pais)
            return otrosEjercitos.generarDivision(1)
        }
        return this
    }

    private fun confirmarNuevaDivisionDe(numeroFuerzas: Int): Ejercitos {
        restarEjercitos(numeroFuerzas)
        return Ejercitos(numeroFuerzas, comandante)
    }

    fun avisarOcupacionExitosa(unPais: Pais) {
        comandante.ocupasteA(unPais)
    }

    private fun fueDerrotado(): Boolean {
        return condicionActual.estanDerrotados()
    }

    override fun equals(otroObjeto: Any?): Boolean {
        if (this === otroObjeto) return true else if (otroObjeto == null || otroObjeto::class != Ejercitos::class) return false
        val otroEjercito = otroObjeto as Ejercitos
        return otroEjercito.comandante == comandante && otroEjercito.condicionActual.equals(condicionActual)
    }

    fun moverEjercitoACon(otroEjercito: Ejercitos, cantidad: Int) {
        if (condicionActual.getCantidadFuerzas() <= cantidad) {
            throw MovimientoDeEjercitoError("No hay fuerzas suficientes para realizar el movimiento")
        }
        restarEjercitos(cantidad)
        otroEjercito.agregarEjercitos(cantidad)
    }

}