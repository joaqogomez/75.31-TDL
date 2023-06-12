package edu.fiuba.algo3.vista.Botones

import edu.fiuba.algo3.Controlador.handlers.BotonComienzoHandler
import javafx.scene.control.Button

class BotonComienzo : Button("Comenzar Juego") {
    init {
        val botonComienzoHandler = BotonComienzoHandler()
        onAction = botonComienzoHandler
        setEstilo()
        setPosicion()
    }

    private fun setEstilo() {
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
    }

    private fun setPosicion() {
        this.translateX = 912.0
        this.translateY = 300.0
    }
}