package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.modelo.Batalla.Pais
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.vista.Elementos.TextoNotificable
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
        textoDeError.setText("Selecciona un pais tuyo")
    }
}