package Controlador.handlers

import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import javafx.scene.input.MouseEvent

class AtaqueInvalidoHandler(var textoDeError: TextoNotificable?) : HandlerDePais {
    override fun asociarPais(unPais: Pais?) {
        //No hace nada
    }

    override fun getCopy(): HandlerDePais? {
        return EsePaisNoEsTuyoHandler(textoDeError)
    }

    override fun desarmarHandler() {
        //no hace nada
    }

    override fun setJugadorEnTurno(jugador: Jugador?) {
        //no hace nada
    }

    override fun handle(mouseEvent: MouseEvent?) {
        setTexto()
    }

    private fun setTexto() {
        textoDeError?.text = "Selecciona un pais tuyo"
    }
}