package edu.fiuba.algo3.Controlador

import edu.fiuba.algo3.modelo.Batalla.Pais

class SeleccionJugador(var paisUno: Pais?, var paisDos: Pais?, var cantidad: Int) {
    fun getPaisUno(): Pais? {
        return paisUno
    }

    fun getPaisDos(): Pais? {
        return paisDos
    }

    fun getCantidad(): Int {
        return cantidad
    }
}