package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.Controlador.Controlador
import edu.fiuba.algo3.modelo.Batalla.Pais
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.vista.Elementos.TextoNotificable
import javafx.scene.input.MouseEvent
import javafx.scene.text.Text

class BotonAtacarHandle(private var jugador: Jugador?, private val textoDeError: TextoNotificable?) : HandlerDePais {
    private var pais: Pais? = null
    private val textoPais: Text?

    init {
        textoPais = Text()
    }

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
        Controlador.habilitarPaises(pais, ConfirmacionAtaqueHandle(jugador, pais, textoDeError))
    }

    private fun desarmarTextoDeError() {
        textoDeError.setText("")
    }
}