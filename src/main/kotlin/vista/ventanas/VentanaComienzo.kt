package vista.ventanas

import edu.fiuba.algo3.vista.Botones.BotonComienzo
import edu.fiuba.algo3.vista.ventanas.VentanaPrincipal
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.layout.StackPane

class VentanaComienzo : StackPane() {
    init {
        prepararImagen()
    }

    private fun prepararImagen() {
        val panel: Group = VentanaPrincipal()
        val comienzo = prepararBotonInicio()
        panel.children.add(comienzo)
        children.add(panel)
    }

    private fun prepararBotonInicio(): Button? {
        val botonComienzo: Button = BotonComienzo()
        children.addAll(botonComienzo)
        return botonComienzo
    }
}