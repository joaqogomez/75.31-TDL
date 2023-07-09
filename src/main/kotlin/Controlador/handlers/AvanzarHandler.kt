package Controlador.handlers

import Controlador.Controlador
import musica.ControladorMusica
import vista.Elementos.TextoNotificable
import vista.ventanas.VentanaDePapel
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.stage.Stage

class AvanzarHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent?.source as Node).scene.window as Stage
        val scena: Scene? = try {
            Controlador.pedirMenuSiguiente()
        } catch (exception: Exception) {
            mostrarError(exception)
            return
        }
        stage.scene = scena
        stage.show()
        val c = ControladorMusica.getInstance()
        c.playEffect()
        c.soundRestart()
    }

    private fun mostrarError(exception: Exception?) {
        val texto = TextoNotificable()
        texto.text = exception!!.message
        val ventana = VentanaDePapel(texto)
        ventana.prepararFondo(200, 300)
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}