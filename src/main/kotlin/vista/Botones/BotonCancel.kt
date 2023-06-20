package vista.Botones

import Controlador.handlers.BotonVolverASeleccionHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button

class BotonCancel : Button() {
    init {
        addEventHandler(ActionEvent.ACTION, BotonVolverASeleccionHandler())
        colocarBoton()
        colocarTexto()
    }

    private fun colocarBoton() {
        this.translateX = 940.0
        this.translateY = 570.0
    }

    private fun colocarTexto() {
        text = "Cancelar"
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
    }
}