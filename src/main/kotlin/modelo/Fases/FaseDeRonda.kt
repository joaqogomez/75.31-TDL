package modelo.Fases

import modelo.JuegoYJugador.InventarioDeJuego
import modelo.JuegoYJugador.Jugador
import modelo.SeleccionJugador

interface FaseDeRonda {
    fun aplicarAccionesDeFase(jugador: Jugador, inventario: InventarioDeJuego)
    fun accionJugador(jugador: Jugador, inventarioDeJuego: InventarioDeJuego, seleccion: SeleccionJugador): Boolean
    fun cambiarFase(siguiente: Jugador): FaseDeRonda
    fun puedoPasar(): Boolean
}