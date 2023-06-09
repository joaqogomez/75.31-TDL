package vista.ventanas

import vista.Elementos.BarraMenu
import javafx.scene.Group
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox

class VentanaPrincipal : Group() {
    var menu: BarraMenu = BarraMenu()

    init {
        setFondo()
    }

    fun setFondo() {
        val contenedor = BorderPane()
        val mapa = HBox()
        val imageMapa = ImageView()
        imageMapa.image = Image("file:src/main/resources/tableroTEG.png")
        imageMapa.fitHeight = 600.0
        mapa.children.add(imageMapa)
        contenedor.top = menu
        contenedor.center = mapa
        children.add(contenedor)
        val imagePanel = ImageView()
        imagePanel.image = Image("file:src/main/resources/papel.jpg")
        imagePanel.fitHeight = 600.0
        imagePanel.fitWidth = 250.0
        mapa.children.add(imagePanel)
    }
}