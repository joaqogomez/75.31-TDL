package Controlador.handlers

import Controlador.Controlador
import javafx.animation.PauseTransition
import javafx.event.ActionEvent
import javafx.event.EventHandler
import modelo.Batalla.Pais
import modelo.JuegoYJugador.Jugador
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import javafx.util.Duration
import vista.ventanas.VentanaDados

class ConfirmacionAtaqueHandle(
    private var jugador: Jugador?,
    private val paisOrigen: Pais?,
    private val textoDeError: TextoNotificable?
) : HandlerDePais {
    private var paisDestino: Pais? = null
    override fun asociarPais(unPais: Pais?) {
        paisDestino = unPais
    }

    override fun getCopy(): HandlerDePais {
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
            val b = jugador?.atacarPaisDesdeA(paisOrigen!!, paisDestino!!)
            val stageAyuda = Stage()
            val sceneAyuda = Scene(VentanaDados(b!!.resultadoDadoAtacante, b.resultadoDadoDefensor), 300.0, 300.0)
            stageAyuda.title = "Resultados"
            stageAyuda.scene = sceneAyuda
            stageAyuda.show()
            val delay = PauseTransition(Duration.seconds(5.0))
            delay.onFinished = EventHandler { event: ActionEvent? -> stageAyuda.close() }
            delay.play()

            evaluarVictoriaDelJugador(mouseEvent)
            Controlador.reestablecerPaises(jugador, BotonAtacarHandle(jugador, textoDeError))
        } catch (excepcion: Exception) {
            if (excepcion.javaClass == NullPointerException::class.java) {
                textoDeError!!.text = "Elige un pais tuyo"
            } else {
                textoDeError!!.text = excepcion.message
                Controlador.reestablecerPaises(jugador, BotonAtacarHandle(jugador, textoDeError))
            }
            mostrarError()
        }
    }

    private fun evaluarVictoriaDelJugador(evento: MouseEvent?) {
        try {
            if (jugador!!.gane()) {
                Controlador.gano(evento, jugador!!)
            }
        } catch (ignored: Exception) {
        }
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