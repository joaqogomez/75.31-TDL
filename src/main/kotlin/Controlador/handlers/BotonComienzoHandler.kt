package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.vista.ventanas.VentanaCantidadJugadores
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
        val stage = (actionEvent.getSource() as Node).scene.window as Stage
        stage.scene = nextScene
        stage.fullScreenExitHint = ""
    }
}