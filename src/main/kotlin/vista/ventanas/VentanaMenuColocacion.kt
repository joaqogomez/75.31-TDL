package vista.ventanas

import vista.Botones.BotonAvanzarTurno
import vista.Elementos.Ficha
import vista.Elementos.TextoNotificable
import javafx.scene.control.Button
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

class VentanaMenuColocacion(private val fichaJugador: Ficha) : VentanaMenu() {
    private val x = 1075
    private val y = 45

    init {
        setTexto()
        agregarBotonAvanze()
        colocarFicha()
    }

    private fun setTexto() {
        val fichasRestantes: Text = TextoNotificable(fichaJugador)
        fichasRestantes.translateX = 900.0
        fichasRestantes.translateY = 200.0
        children.add(fichasRestantes)
        val fase = Text("FASE DE COLOCACION")
        fase.translateX = 320.0
        fase.translateY = 100.0
        fase.font = Font.font(
            "times new roman",
            FontWeight.EXTRA_BOLD,
            FontPosture.REGULAR,
            20.0
        )
        fase.fill = Color.BLACK
        children.add(fase)
    }

    private fun agregarBotonAvanze() {
        val avanze: Button = BotonAvanzarTurno()
        children.add(avanze)
    }

    private fun colocarFicha() {
        fichaJugador.translateX = x.toDouble()
        fichaJugador.radius = 15.0
        fichaJugador.translateY = y.toDouble()
        children.add(fichaJugador)
    }
}