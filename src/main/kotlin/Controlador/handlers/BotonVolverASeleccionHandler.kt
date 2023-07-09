package Controlador.handlers

import vista.ventanas.VentanaCantidadJugadores
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
        val stage = (actionEvent?.source as Node).scene.window as Stage
        val seleccion = Scene(seleccion)
        stage.scene = seleccion
        stage.show()
    }
}