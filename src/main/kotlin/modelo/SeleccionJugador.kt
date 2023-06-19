package modelo

import modelo.Batalla.Pais

class SeleccionJugador(paisUno: Pais, paisDos: Pais, cantidad: Int) {
    private var paisUno: Pais = paisUno
    private var paisDos: Pais = paisDos
    private var cantidad: Int = cantidad

    fun getPaisUno(): Pais {
        return paisUno
    }

    fun getPaisDos(): Pais {
        return paisDos
    }

    fun getCantidad(): Int {
        return cantidad
    }

}

