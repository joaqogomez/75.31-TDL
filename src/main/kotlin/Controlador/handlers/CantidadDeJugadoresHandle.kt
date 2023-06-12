package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.Controlador.Controlador
import edu.fiuba.algo3.vista.ventanas.VentanaNombrarJugadores
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import javafx.stage.Stage

class CantidadDeJugadoresHandle(private val cantidadDeJugadores: Int?) : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent.getSource() as Node).scene.window as Stage
        val grupo: Group = VentanaNombrarJugadores(cantidadDeJugadores)
        val scena = Scene(grupo)
        Controlador.setearJuego(cantidadDeJugadores)
        stage.scene = scena
        stage.show()
    }
}