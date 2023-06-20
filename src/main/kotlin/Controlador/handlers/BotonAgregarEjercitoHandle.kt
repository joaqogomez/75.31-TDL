package Controlador.handlers

import Controlador.Controlador
import modelo.Batalla.Pais
import modelo.Excepciones.ColocacionEjercitoError
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
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
        /*
        try {
            jugador.agregarFichasA(1, pais)
            Controlador.habilitarPaisesParaColocacion(BotonAgregarEjercitoHandle(jugador, textoDeError))
        } catch (exception: Exception) {
            generarTextoDeError(exception)
            mostrarError()
        }
         */
    }

    private fun desarmarTextoDeError() {
        textoDeError!!.text = ""
    }

    private fun generarTextoDeError(exception: Exception?) {
        /*
        if (ColocacionEjercitoError::class.java == exception.javaClass) {
            textoDeError.setText("Ese pais no es tuyo: " + pais.getNombreDelPais())
        } else {
            textoDeError.setText("No tenes mas fichas!")
        }
         */
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