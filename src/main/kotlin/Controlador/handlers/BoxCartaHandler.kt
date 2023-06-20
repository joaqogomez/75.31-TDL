package Controlador.handlers

import modelo.Cartas.Carta
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class BoxCartaHandler(private var jugador: Jugador?, private val textoDeError: TextoNotificable?) : HandlerDeCarta {
    private var primeraCarta: Carta? = null
    override fun asociarCarta(carta: Carta?) {
        primeraCarta = carta
    }

    override fun getCopy(): HandlerDeCarta? {
        return BoxCartaHandler(jugador, textoDeError)
    }

    override fun desarmarHandler() {
        jugador = null
    }

    override fun handle(mouseEvent: MouseEvent?) {
        desarmarTextoDeError()
        /*
        if (mouseEvent!!.button == MouseButton.PRIMARY) {
            primeraCarta.getBox().activarse()
            try {
                jugador.elegirCarta(primeraCarta, null, BoxCartaHandlerDos(primeraCarta, jugador, textoDeError))
            } catch (error: Exception) {
            }
        } else {
            try {
                jugador.canjearCarta(primeraCarta)
                val stage = (mouseEvent.getSource() as Node).scene.window as Stage
                stage.close()
                jugador.mostrarCartas()
            } catch (error: Exception) {
                textoDeError!!.text = error.message
                mostrarError()
            }
        }
         */
    }

    private fun desarmarTextoDeError() {
        textoDeError!!.text = ""
    }

    private fun mostrarError() {
        val ventana = VentanaDePapel(textoDeError!!)
        ventana.prepararFondo(200, 300)
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}