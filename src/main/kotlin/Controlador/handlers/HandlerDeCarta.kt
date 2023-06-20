package Controlador.handlers

import modelo.Cartas.Carta
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

interface HandlerDeCarta : EventHandler<MouseEvent?> {
    open fun asociarCarta(unaCarta: Carta?)
    open fun getCopy(): HandlerDeCarta?
    open fun desarmarHandler()
}