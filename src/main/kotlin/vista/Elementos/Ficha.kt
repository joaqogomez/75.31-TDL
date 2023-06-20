package vista.Elementos

import Controlador.handlers.HandlerDePais
import vista.Elementos.TextoNotificable
import modelo.Batalla.Pais
import javafx.scene.Group
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import javafx.scene.text.Text

class Ficha(color: String?, pais: Pais) : Circle() {
    private var miPais: Pais
    private val texto: Text
    private var textoNotificable: TextoNotificable? = null

    init {
        fill = Paint.valueOf(color)
        texto = Text("10")
        texto.fill = Paint.valueOf("#ffffff")
        texto.style = "-fx-font-weight: bold"
        radius = 12.0
        miPais = pais
    }

    fun setPosicion(posX: Int, posY: Int) {
        this.translateX = posX.toDouble()
        this.translateY = posY.toDouble()
        texto.translateX = (posX - 6).toDouble()
        texto.translateY = (posY + 4).toDouble()
    }

    fun agregarseA(parent: Group) {
        parent.children.add(this)
        parent.children.add(texto)
    }

    fun setColor(nuevoColor: String?) {
        fill = Paint.valueOf(nuevoColor)
    }

    fun agregarNuevoHandler(handler: HandlerDePais?) {
        this.onMouseClicked = handler
        texto.onMouseClicked = handler
        this.isDisable = false
        texto.isDisable = false
    }

    fun notificar(color: String?, fichasDisponibles: Int?) {
        fill = Paint.valueOf(color)
        texto.text = fichasDisponibles.toString()
        if (textoNotificable != null) {
            textoNotificable!!.notificar(texto)
        }
    }

    fun getCantidad(): Text {
        return texto
    }

    fun notificame(textoNotificable: TextoNotificable?) {
        this.textoNotificable = textoNotificable
    }

    fun limpiarHandler() {
        if (this.onMouseClicked != null) {
            val handler = this.onMouseClicked as HandlerDePais
            handler.desarmarHandler()
        }
    }

    fun copiarEn(unaFicha: Ficha, pais: Pais) {
        val handlerDelOtro = unaFicha.onMouseClicked as HandlerDePais
        val miHandlerNuevo = handlerDelOtro.getCopy()
        miHandlerNuevo?.asociarPais(pais)
        agregarNuevoHandler(miHandlerNuevo)
    }

    fun asociarA(pais: Pais) {
        miPais = pais
    }
}