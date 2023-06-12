package vista

import musica.ControladorMusica
import vista.ventanas.VentanaComienzo
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class Tablero : Application() {
    @Throws(Exception::class)
    override fun start(stage: Stage?) {
        stage.setTitle("A.L.T.E.G.O.")
        ControladorMusica()
        val ventanaComienzo = VentanaComienzo()
        val escenaComienzo = Scene(ventanaComienzo)
        stage.setScene(escenaComienzo)
        stage.show()
        ControladorMusica.Companion.playBackgroundMusic()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(*args)
        }
    }
}