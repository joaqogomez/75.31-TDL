package edu.fiuba.algo3.vista.Botones

import edu.fiuba.algo3.Controlador.handlers.CerrarHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button

class BotonSalir : Button() {
    init {
        addEventHandler(ActionEvent.ACTION, CerrarHandler())
        prepararEstilo()
    }

    private fun prepararEstilo() {
        text = "Cerrar"
        style = "-fx-font-weight: bold; -fx-background-color: #ffebcd; -fx-border-color: #000000"
    }

    fun setPosicion(posX: Int, posY: Int) {
        this.translateX = posX.toDouble()
        this.translateY = posY.toDouble()
    }
}