package modelo.Fases

import modelo.Excepciones.ColocacionEjercitoError
import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Jugador
import modelo.SeleccionJugador

class FaseSegundaColocacion(jugador: Jugador) : FaseDeRonda {
    private val fichasAAgregar = 3
    override var jugadorEnTurno: Jugador = jugador


    override fun aplicarAccionesDeFase(jugador: Jugador, inventario: InventarioDeJuego) {
        jugadorEnTurno = jugador
        jugador.agregarFichas(fichasAAgregar)
    }

    override fun accionJugador(jugador: Jugador, inventarioDeJuego: InventarioDeJuego, seleccion: SeleccionJugador): Boolean {
        jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno())
        return true
    }

    override fun cambiarFase(siguiente: Jugador): FaseDeRonda {
        return FaseAtacar(siguiente)
    }

    override fun puedoPasar(): Boolean {
        return if (!jugadorEnTurno.quedanFichas()) true else throw ColocacionEjercitoError("Aun quedan fichas por colocar")
    }

    override fun tipo(): String {
        return "segunda_colocacion"
    }
}
