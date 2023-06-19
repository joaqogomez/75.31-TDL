package vista.Elementos

import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta
import modelo.Cartas.Carta
import javafx.scene.Group
import javafx.scene.paint.Paint
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType
import javafx.scene.text.Text

class BoxCarta(private val carta: Carta) : Rectangle() {
    private var textoSimbolo: Text? = null
    private var textoPais: Text? = null
    private var colorActual: String? = "#ffebcd"

    init {
        height = 100.0
        width = 110.0
        formatearTexto(carta)
        formatearVista()
    }

    private fun formatearVista() {
        desactivarse()
        stroke = Paint.valueOf("#000000")
        this.strokeType = StrokeType.INSIDE
    }

    private fun formatearTexto(carta: Carta) {
        textoSimbolo = Text("Simbolo")
        textoSimbolo!!.fill = Paint.valueOf("#000000")
        textoSimbolo!!.style = "-fx-font-weight: bold"
        textoPais = Text(carta.getPais().getNombreDelPais())
        textoPais!!.fill = Paint.valueOf("#000000")
        textoPais!!.style = "-fx-font-weight: bold"
        fill = Paint.valueOf("#000000")
    }

    fun setPosicion(posX: Int, posY: Int) {
        this.translateX = posX.toDouble()
        this.translateY = posY.toDouble()
        textoSimbolo?.translateX = (posX + 15).toDouble()
        textoSimbolo?.translateY = (posY + 15).toDouble()
        textoPais?.translateX = (posX + 15).toDouble()
        textoPais?.translateY = (posY + 35).toDouble()
    }

    fun agregarseA(parent: Group) {
        parent.children.add(this)
        parent.children.add(textoSimbolo)
        parent.children.add(textoPais)
    }

    fun agregarNuevoHandler(handler: HandlerDeCarta?) {
        this.onMouseClicked = handler
        textoSimbolo?.onMouseClicked = handler
        textoPais?.onMouseClicked = handler
    }

    fun limpiarHandler() {
        if (this.onMouseClicked != null) {
            val handler = this.onMouseClicked as HandlerDeCarta
            handler.desarmarHandler()
        }
        desactivarse()
    }

    fun copiarEn(unaCarta: BoxCarta, otraCarta: Carta) {
        val handlerDelOtro = unaCarta.onMouseClicked as HandlerDeCarta
        val miHandlerNuevo = handlerDelOtro.getCopy()
        miHandlerNuevo!!.asociarCarta(otraCarta)
        agregarNuevoHandler(miHandlerNuevo)
    }

    fun meActive() {
        colorActual = "#ffd79a"
        fill = Paint.valueOf(colorActual)
    }

    fun volviAlMazo() {
        colorActual = "#ffebcd"
    }

    fun activarse() {
        fill = Paint.valueOf("#008000")
        this.isDisable = true
        textoSimbolo!!.isDisable = true
        textoPais!!.isDisable = true
        textoPais!!.isDisable = true
    }

    private fun desactivarse() {
        fill = Paint.valueOf(colorActual)
        this.isDisable = false
        textoSimbolo!!.isDisable = false
        textoPais!!.isDisable = false
        textoPais!!.isDisable = false
    }
}