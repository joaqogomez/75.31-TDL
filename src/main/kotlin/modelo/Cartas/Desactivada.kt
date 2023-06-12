package modelo.Cartas

import modelo.Batalla.Pais

class Desactivada : EstadoDeActivacion {
    private val cantidadDeEjercitos = 2
    override fun activarseEn(unPais: Pais): EstadoDeActivacion {
        unPais.agregarEjercito(cantidadDeEjercitos)
        return Activada()
    }

    override fun estaActivada(): Boolean {
        return false
    }

}
