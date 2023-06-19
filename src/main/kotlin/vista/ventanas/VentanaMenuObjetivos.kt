package vista.ventanas

import vista.Botones.BotonEmpezarColocacion
import javafx.scene.Node
import javafx.scene.control.Button
import java.util.*

class VentanaMenuObjetivos(nodosDeJugadores: ArrayList<Node>) : VentanaMenu() {
    init {
        acomodarNodos(nodosDeJugadores)
        children.addAll(nodosDeJugadores)
        ponerBotonAvance()
    }

    private fun ponerBotonAvance() {
        val botonAvance: Button = BotonEmpezarColocacion()
        children.add(botonAvance)
    }

    private fun acomodarNodos(nodosDeJugadores: ArrayList<Node>) {
        var posY = 200
        for (nodo in nodosDeJugadores) {
            nodo.translateX = 910.0
            nodo.translateY = posY.toDouble()
            posY += 40
        }
    }
}