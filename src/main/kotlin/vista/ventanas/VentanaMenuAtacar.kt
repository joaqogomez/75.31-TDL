package edu.fiuba.algo3.vista.ventanas

import edu.fiuba.algo3.vista.Botones.BotonAvanzarTurno
import edu.fiuba.algo3.vista.Elementos.Ficha
import javafx.scene.control.Button
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

class VentanaMenuAtacar(private val fichaJugador: Ficha?) : VentanaMenu() {
    init {
        setTexto()
        agregarBotonAvanze()
        colocarFicha()
    }

    private fun setTexto() {
        val fase = Text("FASE DE ATAQUE")
        fase.translateX = 350.0
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
        fichaJugador.setTranslateX(1075.0)
        fichaJugador.setRadius(15.0)
        fichaJugador.setTranslateY(45.0)
        children.add(fichaJugador)
    }
}