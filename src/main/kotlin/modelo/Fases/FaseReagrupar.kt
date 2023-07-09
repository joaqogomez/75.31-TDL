package modelo.Fases

import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Jugador
import modelo.SeleccionJugador

class FaseReagrupar(jugador: Jugador) : FaseDeRonda {
    override var jugadorEnTurno: Jugador = jugador


    override fun aplicarAccionesDeFase(jugador: Jugador, inventario: InventarioDeJuego) {
        jugadorEnTurno = jugador
    }

    override fun accionJugador(jugador: Jugador, inventarioDeJuego: InventarioDeJuego, seleccion: SeleccionJugador): Boolean {
        try {
            jugador.moverFichasDeACon(seleccion.getPaisUno(), seleccion.getPaisDos(), seleccion.getCantidad())
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun cambiarFase(siguiente: Jugador): FaseDeRonda {
        return FaseColocarEjercitos(siguiente)
    }

    override fun puedoPasar(): Boolean {
        return true
    }

    override fun tipo(): String {
        return "reagrupar"
    }
}
