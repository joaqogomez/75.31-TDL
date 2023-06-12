package modelo.Cartas

import modelo.Batalla.Pais

interface EstadoDeActivacion {
    fun activarseEn(unPais: Pais): EstadoDeActivacion
    fun estaActivada(): Boolean
}
