package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.vista.ventanas.VentanaDePapel
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.text.Text
import javafx.stage.Stage

class MostrarObjetivoHandler(var textoDeObjetivo: Text?, nombreJugador: String?) : EventHandler<ActionEvent?> {
    var textoDeJugador: Text? = null

    init {
        prepararTextoJugador(nombreJugador)
    }

    private fun prepararTextoJugador(nombre: String?) {
        textoDeJugador = Text("Objetivo de: $nombre")
        textoDeJugador.setTranslateY(50.0)
        textoDeJugador.setTranslateX(60.0)
        textoDeJugador.setStyle("-fx-font-weight: bold")
    }

    override fun handle(actionEvent: ActionEvent?) {
        val ventana = VentanaDePapel(textoDeObjetivo)
        ventana.prepararFondo(200, 310)
        ventana.children.add(textoDeJugador)
        val scena = Scene(ventana)
        val popUpDeObjetivo = Stage()
        popUpDeObjetivo.scene = scena
        popUpDeObjetivo.show()
    }
}