package Controlador.handlers

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

interface HandlerDePais : EventHandler<MouseEvent?> {
    open fun asociarPais(unPais: Pais?)
    open fun getCopy(): HandlerDePais?
    open fun desarmarHandler()
    open fun setJugadorEnTurno(jugador: Jugador?)
}