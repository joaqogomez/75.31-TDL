package modelo.Fases

import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Jugador
import modelo.SeleccionJugador

class FaseAtacar(jugador: Jugador) : FaseDeRonda {
    override var jugadorEnTurno: Jugador = jugador

    override fun aplicarAccionesDeFase(jugador: Jugador, inventario: InventarioDeJuego) {
        jugadorEnTurno = jugador
    }

    override fun accionJugador(jugador: Jugador, inventarioDeJuego: InventarioDeJuego, seleccion: SeleccionJugador): Boolean {
        try {
            jugador.atacarPaisDesdeA(seleccion.getPaisUno(), seleccion.getPaisDos())
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun cambiarFase(siguiente: Jugador): FaseDeRonda {
        return FaseReagrupar(siguiente)
    }

    override fun puedoPasar(): Boolean {
        return true
    }

    override fun tipo(): String {
        return "atacar"
    }

}