package Controlador.handlers

import modelo.JuegoYJugador.InventarioDeJugador
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.text.Text
import javafx.stage.Stage
import vista.Elementos.BoxCarta
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
import java.util.ArrayList

class MostrarCartasHandler(var inventario: InventarioDeJugador) : EventHandler<ActionEvent?> {
    private var boxCartas : ArrayList<BoxCarta> = ArrayList()
    private var xInicial = 15
    private val yInicial = 15

    init {
        val cartas = inventario.getCartas()
        for (carta in cartas) {
            boxCartas.add(BoxCarta(carta))
        }
    }

    override fun handle(actionEvent: ActionEvent?) {
        for (b in boxCartas) {
            b.limpiarHandler()
        }
        val ventana = VentanaDePapel(Text())
        ventana.prepararFondo(200, 600)
        val handler: HandlerDeCarta = BoxCartaHandler(inventario.duenoDelCuartel, TextoNotificable())
        for (boxCarta in boxCartas) {
            boxCarta.agregarNuevoHandler(handler.getCopy())
            boxCarta.setPosicion(xInicial, yInicial)
            boxCarta.agregarseA(ventana)
            xInicial += 110
        }
        xInicial = 15
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.title = "Cartas de: " + inventario.duenoDelCuartel.nombreJugador
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}