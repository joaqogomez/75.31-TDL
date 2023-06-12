package edu.fiuba.algo3.vista.Botones

import edu.fiuba.algo3.Controlador.handlers.AvanzarHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button

class BotonEmpezarColocacion : Button() {
    init {
        addEventHandler(ActionEvent.ACTION, AvanzarHandler())
        setPropiedades()
    }

    private fun setPropiedades() {
        this.translateX = 940.0
        this.translateY = 580.0
        style = "-fx-font-weight: bold; -fx-background-color: #ffebcd; -fx-border-color: #000000"
        text = "Avanzar"
    }
}