package Controlador.handlers

import vista.ventanas.VentanaCreditos
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage

class CreditosHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stageCreditos = Stage()
        val sceneCreditos = Scene(VentanaCreditos(), 700.0, 400.0)
        stageCreditos.title = "Creditos A.L.T.E.G.O."
        stageCreditos.scene = sceneCreditos
        stageCreditos.show()
    }
}