package Controlador.handlers

import Controlador.Controlador
import Controlador.EstadoJuego
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.File
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import java.util.ArrayList

class BotonCargarHandler : EventHandler<ActionEvent?> {

    init {
        val estado = obtenerEstado()
        Controlador.setearJuego(estado.estado.size)
        var textos = ArrayList<String>()
        for (jugador in estado.estado){
            textos.add(jugador.nombre)
        }
        Controlador.cargarNombres(textos)
        Controlador.empezarJuego()
        Controlador.cargarFichas(estado.estado)
    }

    private fun obtenerEstado(): EstadoJuego {
        val estado = File("src/main/resources/partida.json").readText(Charsets.UTF_8)
        return Json.decodeFromString<EstadoJuego>(estado)
    }

    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent?.source as Node).scene.window as Stage
        val scena = Controlador.obtenerEscenaObjetivos()
        stage.scene = scena
        stage.show()
    }
}