package vista.Botones

import edu.fiuba.algo3.Controlador.handlers.BotonComenzarJuegoHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.TextField
import java.util.*

class BotonComenzar(textos: ArrayList<TextField?>?) : Button() {
    init {
        colocarBoton()
        colocarTexto()
        addEventHandler(ActionEvent.ACTION, BotonComenzarJuegoHandler(textos))
    }

    private fun colocarTexto() {
        text = "Comenzar juego"
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
    }

    private fun colocarBoton() {
        this.translateX = 915.0
        this.translateY = 530.0
    }
}