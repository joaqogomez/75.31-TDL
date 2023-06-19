package vista.ventanas

import vista.Elementos.TextoComoJugar
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

class VentanaComoJugar : StackPane() {
    init {
        val imagen = ImageView("file:papel.jpg")
        imagen.fitHeight = 600.0
        imagen.fitWidth = 800.0
        imagen.fitHeightProperty()
        imagen.fitWidthProperty()
        children.add(imagen)
        val contenedor = VBox()
        contenedor.padding = Insets(20.0)
        contenedor.alignment = Pos.CENTER
        val titulo = Text("Como Jugar el juego")
        titulo.font =
            Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18.0)
        titulo.style = "-fx-font-weight: bold"
        titulo.isUnderline = true
        titulo.fill = Color.BLACK
        contenedor.children.add(titulo)
        contenedor.children.add(TextoComoJugar())
        super.getChildren().add(contenedor)
    }
}