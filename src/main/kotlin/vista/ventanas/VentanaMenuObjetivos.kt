package edu.fiuba.algo3.vista.ventanas

import edu.fiuba.algo3.vista.Botones.BotonEmpezarColocacion
import javafx.scene.Node
import javafx.scene.control.Button

class VentanaMenuObjetivos(nodosDeJugadores: ArrayList<Node?>?) : VentanaMenu() {
    init {
        acomodarNodos(nodosDeJugadores)
        children.addAll(nodosDeJugadores)
        ponerBotonAvance()
    }

    private fun ponerBotonAvance() {
        val botonAvance: Button = BotonEmpezarColocacion()
        children.add(botonAvance)
    }

    private fun acomodarNodos(nodosDeJugadores: ArrayList<Node?>?) {
        var posY = 200
        for (nodo in nodosDeJugadores) {
            nodo.setTranslateX(910.0)
            nodo.setTranslateY(posY.toDouble())
            posY += 40
        }
    }
}