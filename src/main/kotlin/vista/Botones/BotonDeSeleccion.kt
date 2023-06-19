package vista.Botones

import edu.fiuba.algo3.Controlador.handlers.CantidadDeJugadoresHandle
import javafx.event.ActionEvent
import javafx.scene.control.Button

class BotonDeSeleccion(numeroBoton: Int) : Button() {
    init {
        addEventHandler(ActionEvent.ACTION, CantidadDeJugadoresHandle(numeroBoton))
        posicionar(numeroBoton)
        crearTexto(numeroBoton)
    }

    private fun crearTexto(numeroBoton: Int?) {
        text = numeroBoton.toString()
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
    }

    private fun posicionar(numeroBoton: Int) {
        this.translateX = (730 + 10 * (numeroBoton - 2)).toDouble()
        this.translateY = 300.0
    }
}