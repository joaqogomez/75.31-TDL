package edu.fiuba.algo3.Controlador.handlers

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.stage.Stage

class CerrarHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent.getSource() as Node).scene.window as Stage
        stage.close()
    }
}