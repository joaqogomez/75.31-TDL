package Controlador.handlers

import Controlador.Controlador
import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import javafx.scene.input.MouseEvent
import javafx.scene.text.Text

class BotonAtacarHandle(private var jugador: Jugador?, private val textoDeError: TextoNotificable?) : HandlerDePais {
    private var pais: Pais? = null
    private val textoPais: Text = Text()

    override fun asociarPais(unPais: Pais?) {
        pais = unPais
    }

    override fun getCopy(): HandlerDePais? {
        return BotonAtacarHandle(jugador, textoDeError)
    }

    override fun desarmarHandler() {
        jugador = null
    }

    override fun setJugadorEnTurno(jugador: Jugador?) {
        this.jugador = jugador
    }

    override fun handle(mouseEvent: MouseEvent?) {
        desarmarTextoDeError()
        Controlador.habilitarPaises(pais!!, ConfirmacionAtaqueHandle(jugador, pais, textoDeError))
    }

    private fun desarmarTextoDeError() {
        textoDeError!!.text = ""
    }
}