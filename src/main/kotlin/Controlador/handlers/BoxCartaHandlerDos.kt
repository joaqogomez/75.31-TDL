package Controlador.handlers

import modelo.Cartas.Carta
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import javafx.scene.input.MouseEvent

class BoxCartaHandlerDos(
    private val primeraCarta: Carta?,
    private var jugador: Jugador?,
    private val textoDeError: TextoNotificable?
) : HandlerDeCarta {
    private var segundaCarta: Carta? = null
    override fun asociarCarta(carta: Carta?) {
        segundaCarta = carta
    }

    override fun getCopy(): HandlerDeCarta? {
        return BoxCartaHandlerDos(primeraCarta, jugador, textoDeError)
    }

    override fun desarmarHandler() {
        jugador = null
    }

    override fun handle(mouseEvent: MouseEvent?) {
        desarmarTextoDeError()
        /*
        segundaCarta.getBox().activarse()
        try {
            jugador.elegirCarta(
                primeraCarta,
                segundaCarta,
                BoxCartaHandlerTres(primeraCarta, segundaCarta, jugador, textoDeError)
            )
        } catch (error: Exception) {
        }
         */
    }

    private fun desarmarTextoDeError() {
        textoDeError!!.text = ""
    }
}