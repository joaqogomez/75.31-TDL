package vista.ventanas

import vista.Botones.BotonSalir
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.text.Text

class VentanaDePapel(var texto: Text) : Group() {
    init {
        prepararBotonSalir()
    }

    private fun prepararTexto(textoAMostrar: Text) {
        textoAMostrar.translateX = 60.0
        textoAMostrar.translateY = 100.0
        children.add(textoAMostrar)
    }

    fun prepararFondo(altura: Int, anchura: Int) {
        val imagePanel = ImageView()
        imagePanel.image = Image("file:src/main/resources/papel.jpg")
        imagePanel.fitHeight = altura.toDouble()
        imagePanel.fitWidth = anchura.toDouble()
        children.add(imagePanel)
        prepararTexto(texto)
    }

    private fun prepararBotonSalir() {
        val botonSalir: Button = BotonSalir()
        botonSalir.translateY = 170.0
        botonSalir.translateX = 105.0
        children.add(botonSalir)
    }
}