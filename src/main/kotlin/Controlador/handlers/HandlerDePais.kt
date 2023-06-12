package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.modelo.Batalla.Pais
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

interface HandlerDePais : EventHandler<MouseEvent?> {
    open fun asociarPais(unPais: Pais?)
    open fun getCopy(): HandlerDePais?
    open fun desarmarHandler()
    open fun setJugadorEnTurno(jugador: Jugador?)
}