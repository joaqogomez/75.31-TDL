package Controlador.handlers

import Controlador.Controlador
import modelo.Batalla.Pais
import modelo.Excepciones.MovimientoDeEjercitoError
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class ConfirmacionMovimientoHandler(
    private var jugador: Jugador?,
    private val paisOrigen: Pais?,
    private val textoDeError: TextoNotificable?
) : HandlerDePais {
    private var paisDestino: Pais? = null
    override fun asociarPais(unPais: Pais?) {
        paisDestino = unPais
    }

    override fun getCopy(): HandlerDePais? {
        return ConfirmacionMovimientoHandler(jugador, paisOrigen, textoDeError)
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
            jugador.moverFichasDeACon(paisOrigen, paisDestino, 1)
            Controlador.reestablecerPaises(jugador, BotonMoverHandle(jugador, textoDeError))
        } catch (excepcion: Exception) {
            if (excepcion.javaClass == MovimientoDeEjercitoError::class.java) {
                textoDeError.setText(excepcion.message)
                Controlador.reestablecerPaises(jugador, BotonMoverHandle(jugador, textoDeError))
            } else {
                textoDeError.setText("Elige un pais tuyo")
            }
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