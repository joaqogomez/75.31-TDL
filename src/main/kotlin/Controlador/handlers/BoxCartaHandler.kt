package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.modelo.Cartas.Carta
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.vista.Elementos.TextoNotificable
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel
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
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
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
                textoDeError.setText(error.message)
                mostrarError()
            }
        }
    }

    private fun desarmarTextoDeError() {
        textoDeError.setText("")
    }

    private fun mostrarError() {
        val ventana = VentanaDePapel(textoDeError)
        ventana.prepararFondo(200, 300)
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}