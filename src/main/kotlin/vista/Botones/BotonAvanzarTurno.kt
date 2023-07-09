package vista.Botones

import Controlador.handlers.AvanzarHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button

class BotonAvanzarTurno : Button() {
    init {
        addEventHandler(ActionEvent.ACTION, AvanzarHandler())
        colocarBoton()
        colocarTexto()
    }

    private fun colocarBoton() {
        this.translateX = 920.0
        this.translateY = 570.0
        this.translateY = 590.0
    }

    private fun colocarTexto() {
        text = "Pasar turno"
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
    }
}