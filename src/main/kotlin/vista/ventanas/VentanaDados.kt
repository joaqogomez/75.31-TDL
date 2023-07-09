package vista.ventanas

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.*
import java.util.*

class VentanaDados(resultadoDadoAtacante: ArrayList<Int>, resultadoDadoDefensor: ArrayList<Int>) : StackPane() {
    init {
        val imagen = ImageView("file:src/main/resources/papel.jpg")
        imagen.fitHeight = 600.0
        imagen.fitWidth = 800.0
        imagen.fitHeightProperty()
        imagen.fitWidthProperty()
        children.add(imagen)
        val contenedor = VBox()
        contenedor.padding = Insets(20.0)
        contenedor.alignment = Pos.CENTER
        val atacante = Text("Atacante:")
        atacante.font =
            Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18.0)
        atacante.style = "-fx-font-weight: bold"
        atacante.fill = Color.BLACK
        val defensor = Text("Defensor:")
        defensor.font = Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18.0)
        defensor.style = "-fx-font-weight: bold"
        defensor.fill = Color.BLACK
        val resultados = VBox()
        resultados.padding = Insets(20.0)
        resultados.alignment = Pos.CENTER_LEFT
        val resultadoAtacante = estilizarDados(resultadoDadoAtacante)
        val resultadoDefensor = estilizarDados(resultadoDadoDefensor)
        resultados.children.addAll(resultadoAtacante, resultadoDefensor)
        contenedor.children.addAll(atacante, resultadoAtacante, defensor, resultadoDefensor)
        super.getChildren().add(contenedor)
    }

    private fun estilizarDados(unosDados: ArrayList<Int>): Text {
        val dadosChetos = Text()
        var stringDeDados = ""
        for (dado in unosDados) {
            stringDeDados += "$dado   "
        }
        dadosChetos.text = stringDeDados
        dadosChetos.font = Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18.0)
        return dadosChetos
    }
}