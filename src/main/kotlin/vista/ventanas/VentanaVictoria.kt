package vista.ventanas

import modelo.JuegoYJugador.Jugador
import musica.ControladorMusica
import vista.Botones.BotonComienzo
import vista.Botones.BotonSalir
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.paint.Paint
import javafx.scene.text.Text

class VentanaVictoria(jugadorGanador: Jugador) : Group() {
    init {
        prepararFondoDeVentana()
        prepararVentanaDeVictoria(jugadorGanador)
        prepararBotonDeReinicio()
        ControladorMusica.getInstance().playVictory()
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

    private fun setPosiciones(botonDeReinicio: Button, botonDeSalir: Button) {
        botonDeReinicio.translateX = 920.0
        botonDeSalir.translateX = 955.0
        botonDeReinicio.translateY = 550.0
        botonDeSalir.translateY = 580.0
    }

    private fun prepararVentanaDeVictoria(ganador: Jugador) {
        val textoDeVictoria = Text(
            """
    Victoria de: 
    ${ganador.nombreJugador}
    """
        )
        textoDeVictoria.style = "-fx-font: 24 sans-serif; -fx-font-weight: bold;"
        textoDeVictoria.fill = Paint.valueOf(ganador.color)
        textoDeVictoria.translateX = 900.0
        textoDeVictoria.translateY = 50.0
        children.add(textoDeVictoria)
    }

    private fun prepararFondoDeVentana() {
        val principal = VentanaPrincipal()
        children.add(principal)
    }
}