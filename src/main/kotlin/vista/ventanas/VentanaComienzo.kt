package vista.ventanas

import vista.Botones.BotonComienzo
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import vista.Botones.BotonCargar

class VentanaComienzo : StackPane() {
    init {
        prepararImagen()
    }

    private fun prepararImagen() {
        val panel: Group = VentanaPrincipal()
        val comienzo = prepararBotonInicio()
        val cargar = prepararBotonCargar()
        panel.children.add(cargar)
        panel.children.add(comienzo)
        children.add(panel)
    }

    private fun prepararBotonCargar(): Button {
        val botonCargar: Button = BotonCargar()
        children.addAll(botonCargar)
        return botonCargar
    }

    private fun prepararBotonInicio(): Button {
        val botonComienzo: Button = BotonComienzo()
        children.addAll(botonComienzo)
        return botonComienzo
    }
}