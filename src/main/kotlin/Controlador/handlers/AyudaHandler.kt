package Controlador.handlers

import vista.ventanas.VentanaAyuda
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage

class AyudaHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stageAyuda = Stage()
        val sceneAyuda = Scene(VentanaAyuda(), 700.0, 600.0)
        stageAyuda.title = "Ayuda A.L.T.E.G.O."
        stageAyuda.scene = sceneAyuda
        stageAyuda.show()
    }
}