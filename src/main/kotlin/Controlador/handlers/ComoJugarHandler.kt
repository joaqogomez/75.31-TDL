package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.vista.ventanas.VentanaComoJugar
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage

class ComoJugarHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stageComoJugar = Stage()
        val sceneComoJugar = Scene(VentanaComoJugar(), 700.0, 600.0)
        stageComoJugar.title = "Como Jugar A.L.T.E.G.O."
        stageComoJugar.scene = sceneComoJugar
        stageComoJugar.show()
    }
}