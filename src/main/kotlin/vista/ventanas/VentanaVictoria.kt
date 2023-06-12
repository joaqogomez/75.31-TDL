package edu.fiuba.algo3.vista.ventanas

import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.musica.ControladorMusica
import edu.fiuba.algo3.vista.Botones.BotonComienzo
import edu.fiuba.algo3.vista.Botones.BotonSalir
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.paint.Paint
import javafx.scene.text.Text

class VentanaVictoria(jugadorGanador: Jugador?) : Group() {
    init {
        prepararFondoDeVentana()
        prepararVentanaDeVictoria(jugadorGanador)
        prepararBotonDeReinicio()
        ControladorMusica.Companion.playVictory()
    }

    private fun prepararBotonDeReinicio() {
        val botonDeReinicio: Button = BotonComienzo()
        botonDeReinicio.text = "Volver a jugar"
        botonDeReinicio.style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
        val botonDeSalir: Button = BotonSalir()
        botonDeSalir.text = "Salir"
        botonDeSalir.style = "-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000"
        setPosiciones(botonDeReinicio, botonDeSalir)
        children.addAll(botonDeReinicio, botonDeSalir)
    }

    private fun setPosiciones(botonDeReinicio: Button?, botonDeSalir: Button?) {
        botonDeReinicio.setTranslateX(920.0)
        botonDeSalir.setTranslateX(955.0)
        botonDeReinicio.setTranslateY(550.0)
        botonDeSalir.setTranslateY(580.0)
    }

    private fun prepararVentanaDeVictoria(ganador: Jugador?) {
        val textoDeVictoria = Text(
            """
    Victoria de: 
    ${ganador.getNombreJugador()}
    """.trimIndent()
        )
        textoDeVictoria.style = "-fx-font: 24 sans-serif; -fx-font-weight: bold;"
        textoDeVictoria.fill = Paint.valueOf(ganador.getColor())
        textoDeVictoria.translateX = 900.0
        textoDeVictoria.translateY = 50.0
        children.add(textoDeVictoria)
    }

    private fun prepararFondoDeVentana() {
        val principal = VentanaPrincipal()
        children.add(principal)
    }
}