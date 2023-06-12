package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJugador
import javafx.event.ActionEvent
import javafx.event.EventHandler

class MostrarCartasHandler(var inventario: InventarioDeJugador?) : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        inventario.mostrarCartas()
    }
}