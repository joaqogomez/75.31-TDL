package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.Controlador.Controlador
import edu.fiuba.algo3.musica.ControladorMusica
import edu.fiuba.algo3.vista.Elementos.TextoNotificable
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.stage.Stage

class AvanzarHandler : EventHandler<ActionEvent?> {
    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent.getSource() as Node).scene.window as Stage
        val scena: Scene?
        scena = try {
            Controlador.pedirMenuSiguiente()
        } catch (exception: Exception) {
            mostrarError(exception)
            return
        }
        stage.scene = scena
        stage.show()
        ControladorMusica.Companion.playEffect()
        ControladorMusica.Companion.soundRestart()
    }

    private fun mostrarError(exception: Exception?) {
        val texto = TextoNotificable()
        texto.text = exception.message
        val ventana = VentanaDePapel(texto)
        ventana.prepararFondo(200, 300)
        val scena = Scene(ventana)
        val popUpDeCarta = Stage()
        popUpDeCarta.scene = scena
        popUpDeCarta.show()
    }
}