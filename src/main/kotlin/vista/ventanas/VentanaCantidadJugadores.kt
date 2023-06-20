package vista.ventanas

import vista.Botones.BotonDeSeleccion
import vista.Elementos.BarraMenu
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import java.util.*

class VentanaCantidadJugadores : StackPane() {
    init {
        setFondo()
    }

    fun setFondo() {
        val contenedor = BorderPane()
        contenedor.top = BarraMenu()
        val mapa = HBox()
        val imageMapa = ImageView()
        imageMapa.image = Image("file:src/main/resources/tableroTEG.png")
        imageMapa.fitHeight = 600.0
        mapa.children.add(imageMapa)
        children.add(mapa)
        contenedor.center = mapa
        children.add(contenedor)
        val panel = HBox()
        val imagePanel = ImageView()
        imagePanel.image = Image("file:src/main/resources/papel.jpg")
        imagePanel.fitHeight = 600.0
        imagePanel.fitWidth = 250.0
        mapa.children.add(imagePanel)
        children.add(panel)
        val info = Label()
        info.text = "Cantidad de jugadores:"
        info.style = "-fx-font-weight: bold"
        info.translateX = 905.0
        info.translateY = 280.0
        val nodos = ArrayList<Node>()
        nodos.add(info)
        for (i in 2..6) {
            nodos.add(BotonDeSeleccion(i))
        }
        panel.children.addAll(nodos)
    }
}