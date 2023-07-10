package vista.Botones

import Controlador.handlers.BotonCargarHandler
import javafx.scene.control.Button

class BotonCargar: Button("Cargar Partida") {
    init {
        val botonCargarHandler = BotonCargarHandler()
        onAction = botonCargarHandler
        setEstilo()
        setPosicion()
    }

    private fun setEstilo() {
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
    }

    private fun setPosicion() {
        this.translateX = 912.0
        this.translateY = 350.0
    }
}