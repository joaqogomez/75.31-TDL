package Controlador.handlers

import vista.ventanas.VentanaCantidadJugadores
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class BotonComienzoHandler : EventHandler<ActionEvent?> {
    private val nextScene: Scene?

    init {
        val seleccion: StackPane = VentanaCantidadJugadores()
        nextScene = Scene(seleccion)
    }

    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent?.source as Node).scene.window as Stage
        stage.scene = nextScene
        stage.fullScreenExitHint = ""
    }
}