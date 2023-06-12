package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.vista.ventanas.VentanaCreditos
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage

class CreditosHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stageCreditos = Stage()
        val sceneCreditos = Scene(VentanaCreditos(), 450.0, 450.0)
        stageCreditos.title = "Creditos A.L.T.E.G.O."
        stageCreditos.scene = sceneCreditos
        stageCreditos.show()
    }
}