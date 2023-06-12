package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.vista.ventanas.VentanaCantidadJugadores
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class BotonVolverASeleccionHandler : EventHandler<ActionEvent?> {
    private val seleccion: StackPane?

    init {
        seleccion = VentanaCantidadJugadores()
    }

    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent.getSource() as Node).scene.window as Stage
        val seleccion = Scene(seleccion)
        stage.scene = seleccion
        stage.show()
    }
}