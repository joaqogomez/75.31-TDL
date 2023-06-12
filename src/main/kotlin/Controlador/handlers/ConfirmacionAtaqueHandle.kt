package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.Controlador.Controlador
import edu.fiuba.algo3.modelo.Batalla.Pais
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.vista.Elementos.TextoNotificable
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.stage.Stage

class ConfirmacionAtaqueHandle(
    private var jugador: Jugador?,
    private val paisOrigen: Pais?,
    private val textoDeError: TextoNotificable?
) : HandlerDePais {
    private var paisDestino: Pais? = null
    override fun asociarPais(unPais: Pais?) {
        paisDestino = unPais
    }

    override fun getCopy(): HandlerDePais? {
        return ConfirmacionAtaqueHandle(jugador, paisOrigen, textoDeError)
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
            jugador.atacarPaisDesdeAVisual(paisOrigen, paisDestino)
            evaluarVictoriaDelJugador(mouseEvent)
            Controlador.reestablecerPaises(jugador, BotonAtacarHandle(jugador, textoDeError))
        } catch (excepcion: Exception) {
            if (excepcion.javaClass == NullPointerException::class.java) {
                textoDeError.setText("Elige un pais tuyo")
            } else {
                textoDeError.setText(excepcion.message)
                Controlador.reestablecerPaises(jugador, BotonAtacarHandle(jugador, textoDeError))
            }
            mostrarError()
        }
    }

    private fun evaluarVictoriaDelJugador(evento: MouseEvent?) {
        try {
            jugador.evaluarVictoria(evento)
        } catch (ignored: Exception) {
        }
    }

    private fun desarmarTextoDeError() {
        textoDeError.setText("")
    }

    private fun mostrarError() {
        val ventana = VentanaDePapel(textoDeError)
        ventana.prepararFondo(200, 500)
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}