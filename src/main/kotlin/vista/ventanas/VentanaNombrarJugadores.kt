package vista.ventanas

import vista.Botones.BotonCancel
import Botones.BotonComenzar
import vista.Elementos.CampoDeNombre
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.control.TextField
import java.util.*

class VentanaNombrarJugadores(numeroDeJugadores: Int) : Group() {
    init {
        agregarFondo()
        agregarBotonCancel()
        agregarCampos(numeroDeJugadores)
    }

    private fun agregarFondo() {
        val stack: Group = VentanaPrincipal()
        children.add(stack)
    }

    private fun agregarBotonCancel() {
        val cancel: Button = BotonCancel()
        children.addAll(cancel)
    }

    private fun agregarCampos(numeroDeJugadores: Int) {
        val textos = ArrayList<TextField?>()
        for (i in 1..numeroDeJugadores) {
            textos.add(CampoDeNombre(i))
        }
        val comenzar: Button = BotonComenzar(textos)
        children.add(comenzar)
        children.addAll(textos)
    }
}