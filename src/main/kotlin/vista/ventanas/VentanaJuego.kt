package vista.ventanas

import vista.Elementos.Ficha
import javafx.scene.Group
import java.util.*

class VentanaJuego(fichas: ArrayList<Ficha>, menuActual: VentanaMenu) : Group() {
    init {
        prepararMenu()
        agregarElementos(fichas, menuActual)
    }

    private fun agregarElementos(fichas: ArrayList<Ficha>, menuActual: VentanaMenu) {
        agregarFichas(fichas)
        children.add(menuActual)
    }

    private fun prepararMenu() {
        val principal = VentanaPrincipal()
        children.add(principal)
    }

    private fun agregarFichas(fichas: ArrayList<Ficha>) {
        for (ficha in fichas) {
            ficha.agregarseA(this)
        }
    }
}