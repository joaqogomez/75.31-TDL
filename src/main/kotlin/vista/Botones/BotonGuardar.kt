package vista.Botones

import Controlador.EstadoJuego
import Controlador.handlers.GuardarHandler
import javafx.event.ActionEvent
import javafx.scene.control.Button
import kotlinx.coroutines.channels.Channel
import vista.Elementos.Ficha
import java.util.*

class BotonGuardar(fichas: ArrayList<Ficha>, logMessageChannel: Channel<EstadoJuego>) : Button() {
    init {
        val handler = GuardarHandler(fichas, logMessageChannel)
        addEventHandler(ActionEvent.ACTION, handler)
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
        text = "Guardar"
    }
}