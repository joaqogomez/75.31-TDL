package vista.ventanas

import javafx.scene.Group

class VentanaMostrarObjetivos(menuObjetivos: VentanaMenu) : Group() {
    init {
        agregarMenu()
        children.add(menuObjetivos)
    }

    private fun agregarMenu() {
        val menu = VentanaPrincipal()
        children.add(menu)
    }
}