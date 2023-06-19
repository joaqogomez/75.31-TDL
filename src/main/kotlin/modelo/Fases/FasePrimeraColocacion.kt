package modelo.Fases

import modelo.Excepciones.ColocacionEjercitoError
import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Jugador
import modelo.SeleccionJugador

class FasePrimeraColocacion(jugador: Jugador) : FaseDeRonda {

    private val fichasAAgregar = 5
    private var jugadorEnTurno: Jugador = jugador

    override fun aplicarAccionesDeFase(jugador: Jugador, inventario: InventarioDeJuego) {
        jugadorEnTurno = jugador
        jugador.agregarFichas(fichasAAgregar)
    }

    override fun accionJugador(jugador: Jugador, inventarioDeJuego: InventarioDeJuego, seleccion: SeleccionJugador): Boolean {
        jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno())
        return true
    }

    override fun cambiarFase(siguiente: Jugador): FaseDeRonda {
        return FaseSegundaColocacion(siguiente)
    }

    override fun puedoPasar(): Boolean {
        return if (!jugadorEnTurno.quedanFichas()) true else throw ColocacionEjercitoError("Aun quedan fichas por colocar")
    }
}