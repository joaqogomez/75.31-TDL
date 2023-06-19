package vista.Elementos

import edu.fiuba.algo3.Controlador.handlers.AyudaHandler
import edu.fiuba.algo3.Controlador.handlers.ComoJugarHandler
import edu.fiuba.algo3.Controlador.handlers.CreditosHandler
import edu.fiuba.algo3.Controlador.handlers.SalirHandler
import musica.MusicaOffHandler
import musica.MusicaOnHandler
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class BarraMenu : MenuBar() {
    init {
        val menuAyuda = Menu("Ayuda")
        val menuOpciones = Menu("Opciones")
        val menuMusica = Menu("Musica")
        val opcionSalir = MenuItem("Salir")
        val opcionAyudaJuego = MenuItem("Reglas")
        val opcionOffMusica = MenuItem("Off")
        val opcionOnMusica = MenuItem("On")
        val opcionComoJugar = MenuItem("Como Jugar")
        val opcionCreditos = MenuItem("Creditos")
        val imagePanel = ImageView()
        imagePanel.image = Image("file:papel.jpg")
        imagePanel.fitHeight = 30.0
        imagePanel.fitWidth = 1108.0
        opcionSalir.onAction = SalirHandler()
        opcionSalir.style = "-fx-font-weight: bold"
        menuOpciones.items.add(opcionSalir)
        opcionAyudaJuego.onAction = AyudaHandler()
        opcionAyudaJuego.style = "-fx-font-weight: bold"
        opcionComoJugar.onAction = ComoJugarHandler()
        opcionComoJugar.style = "-fx-font-weight: bold"
        opcionCreditos.onAction = CreditosHandler()
        opcionCreditos.style = "-fx-font-weight: bold"
        menuAyuda.items.add(opcionAyudaJuego)
        menuAyuda.items.add(opcionComoJugar)
        menuAyuda.items.add(opcionCreditos)
        opcionOffMusica.onAction = MusicaOffHandler()
        opcionOffMusica.style = "-fx-font-weight: bold"
        opcionOnMusica.onAction = MusicaOnHandler()
        opcionOnMusica.style = "-fx-font-weight: bold"
        menuMusica.items.addAll(opcionOnMusica, opcionOffMusica)
        style = "-fx-font-weight: bold"
        menus.addAll(menuOpciones, menuMusica, menuAyuda)
        children.add(imagePanel)
    }
}