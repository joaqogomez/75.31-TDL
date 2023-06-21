package modelo.Fases

import modelo.Excepciones.ColocacionEjercitoError
import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Jugador
import modelo.SeleccionJugador

class FaseColocarEjercitos(jugador: Jugador) : FaseDeRonda {
    override var jugadorEnTurno: Jugador = jugador

    override fun aplicarAccionesDeFase(jugador: Jugador, inventario: InventarioDeJuego) {
        jugador.pedirCarta(inventario)
        jugadorEnTurno = jugador
        jugador.cantidadDeEjercitosAColocar(inventario)
    }

    override fun accionJugador(jugador: Jugador, inventarioDeJuego: InventarioDeJuego, seleccion: SeleccionJugador): Boolean {
        try {
            jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno())
        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun cambiarFase(siguiente: Jugador): FaseDeRonda {
        return FaseAtacar(siguiente)
    }

    override fun puedoPasar(): Boolean {
        return if (!jugadorEnTurno.quedanFichas()) true else throw ColocacionEjercitoError("Aun quedan fichas por colocar")
    }

    override fun tipo(): String {
        return "colocar_ejercitos"
    }
}
