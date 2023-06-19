package vista.Botones

import edu.fiuba.algo3.Controlador.handlers.MostrarObjetivoHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.text.Text

class BotonMostrarObjetivo(textoDeObjetivo: Text?, nombreJugador: String?, color: String?) : Button() {
    init {
        val handler = MostrarObjetivoHandler(textoDeObjetivo, nombreJugador)
        addEventHandler(ActionEvent.ACTION, handler)
        style = "-fx-background-color: $color; -fx-font-weight: bold;" + "-fx-text-fill: #ffffff"
        text = "Mostrar objetivo"
    }
}