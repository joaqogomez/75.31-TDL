package Controlador.handlers

import modelo.Cartas.Carta
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class BoxCartaHandlerTres(
    private val primeraCarta: Carta?,
    private val segundaCarta: Carta?,
    private var jugador: Jugador?,
    private val textoDeError: TextoNotificable?
) : HandlerDeCarta {
    private var terceraCarta: Carta? = null
    override fun asociarCarta(carta: Carta?) {
        terceraCarta = carta
    }

    override fun getCopy(): HandlerDeCarta? {
        return BoxCartaHandlerTres(primeraCarta, segundaCarta, jugador, textoDeError)
    }

    override fun desarmarHandler() {
        jugador = null
    }

    override fun handle(mouseEvent: MouseEvent?) {
        desarmarTextoDeError()
        /*
        terceraCarta.getBox().activarse()
        try {
            jugador.canjearCartas(primeraCarta, segundaCarta, terceraCarta)
            jugador.habilitarCartas(BoxCartaHandler(jugador, textoDeError))
            val stage = (mouseEvent.getSource() as Node).scene.window as Stage
            stage.close()
            jugador.mostrarCartas()
        } catch (exception: Exception) {
            textoDeError.setText(exception.message)
            mostrarError()
        }
         */
    }

    private fun desarmarTextoDeError() {
        textoDeError!!.text = ""
    }

    private fun mostrarError() {
        val ventana = VentanaDePapel(textoDeError!!)
        ventana.prepararFondo(200, 500)
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}