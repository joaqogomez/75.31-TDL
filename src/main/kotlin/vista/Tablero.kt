package vista

import musica.ControladorMusica
import vista.ventanas.VentanaComienzo
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class Tablero : Application() {
    override fun start(stage: Stage) {
        stage.title = "A.L.T.E.G.O."
        val controladorMusica = ControladorMusica.getInstance()
        val ventanaComienzo = VentanaComienzo()
        val escenaComienzo = Scene(ventanaComienzo)
        stage.scene = escenaComienzo
        stage.show()
        controladorMusica.playBackgroundMusic()
    }
}