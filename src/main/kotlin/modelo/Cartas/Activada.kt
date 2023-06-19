package modelo.Cartas

import modelo.Batalla.Pais

class Activada : EstadoDeActivacion {
    override fun activarseEn(unPais: Pais): EstadoDeActivacion {
        return this
    }

    override fun estaActivada(): Boolean {
        return true
    }
}
