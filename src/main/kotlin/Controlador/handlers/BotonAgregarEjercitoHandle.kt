package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.Controlador.Controlador
import edu.fiuba.algo3.modelo.Batalla.Pais
import edu.fiuba.algo3.modelo.Excepciones.ColocacionEjercitoError
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.vista.Elementos.TextoNotificable
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class BotonAgregarEjercitoHandle(private var jugador: Jugador?, private val textoDeError: TextoNotificable?) :
    HandlerDePais {
    private var pais: Pais? = null
    override fun asociarPais(unPais: Pais?) {
        pais = unPais
    }

    override fun getCopy(): HandlerDePais? {
        return BotonAgregarEjercitoHandle(jugador, textoDeError)
    }

    override fun desarmarHandler() {
        jugador = null
    }

    override fun setJugadorEnTurno(jugador: Jugador?) {
        this.jugador = jugador
    }

    override fun handle(mouseEvent: MouseEvent?) {
        desarmarTextoDeError()
        try {
            jugador.agregarFichasA(1, pais)
            Controlador.habilitarPaisesParaColocacion(BotonAgregarEjercitoHandle(jugador, textoDeError))
        } catch (exception: Exception) {
            generarTextoDeError(exception)
            mostrarError()
        }
    }

    private fun desarmarTextoDeError() {
        textoDeError.setText("")
    }

    private fun generarTextoDeError(exception: Exception?) {
        if (ColocacionEjercitoError::class.java == exception.javaClass) {
            textoDeError.setText("Ese pais no es tuyo: " + pais.getNombreDelPais())
        } else {
            textoDeError.setText("No tenes mas fichas!")
        }
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