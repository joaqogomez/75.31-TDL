package Controlador.handlers

import Controlador.Controlador
import vista.Elementos.Ficha
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.util.*

class BotonComenzarJuegoHandler(private val textos: ArrayList<TextField>?) : EventHandler<ActionEvent?> {

    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent?.source as Node).scene.window as Stage
        Controlador.setearNombres(textos!!)
        Controlador.empezarJuego()
        val scena = Controlador.obtenerEscenaObjetivos()
        stage.scene = scena
        stage.show()
    }
}