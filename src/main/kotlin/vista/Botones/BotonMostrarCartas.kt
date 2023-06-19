package vista.Botones

import edu.fiuba.algo3.Controlador.handlers.MostrarCartasHandler
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJugador
import javafx.event.ActionEvent
import javafx.scene.control.Button

class BotonMostrarCartas(inventario: InventarioDeJugador?) : Button() {
    init {
        val handler = MostrarCartasHandler(inventario)
        addEventHandler(ActionEvent.ACTION, handler)
        style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
        text = "Mostrar Cartas"
    }
}