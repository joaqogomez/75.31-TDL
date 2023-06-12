package edu.fiuba.algo3.Controlador.handlers

import edu.fiuba.algo3.Controlador.Controlador
import edu.fiuba.algo3.vista.Elementos.Ficha
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage

class BotonComenzarJuegoHandler(private val textos: ArrayList<TextField?>?) : EventHandler<ActionEvent?> {
    private var fichas: ArrayList<Ficha?>? = null
    private val numeroDePaises = 50

    init {
        crearFichas()
    }

    private fun crearFichas() {
        fichas = ArrayList()
        for (i in 0 until numeroDePaises) {
            fichas.add(Ficha("#000000"))
        }
    }

    override fun handle(actionEvent: ActionEvent?) {
        val stage = (actionEvent.getSource() as Node).scene.window as Stage
        setearNombres()
        asociarFichas()
        val scena = Controlador.obtenerEscenaObjetivos()
        stage.scene = scena
        stage.show()
    }

    private fun setearNombres() {
        Controlador.setearNombres(textos)
    }

    private fun asociarFichas() {
        Controlador.empezarJuego(fichas)
    }
}