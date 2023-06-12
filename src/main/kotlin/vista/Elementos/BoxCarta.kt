package edu.fiuba.algo3.vista.Elementos

import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta
import edu.fiuba.algo3.modelo.Cartas.Carta
import javafx.scene.Group
import javafx.scene.paint.Paint
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType
import javafx.scene.text.Text

class BoxCarta(private val carta: Carta?) : Rectangle() {
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

    private fun formatearTexto(carta: Carta?) {
        textoSimbolo = Text(carta.getSimbolo())
        textoSimbolo.setFill(Paint.valueOf("#000000"))
        textoSimbolo.setStyle("-fx-font-weight: bold")
        textoPais = Text(carta.getPais().nombreDelPais)
        textoPais.setFill(Paint.valueOf("#000000"))
        textoPais.setStyle("-fx-font-weight: bold")
        fill = Paint.valueOf("#000000")
    }

    fun setPosicion(posX: Int, posY: Int) {
        this.translateX = posX.toDouble()
        this.translateY = posY.toDouble()
        textoSimbolo.setTranslateX((posX + 15).toDouble())
        textoSimbolo.setTranslateY((posY + 15).toDouble())
        textoPais.setTranslateX((posX + 15).toDouble())
        textoPais.setTranslateY((posY + 35).toDouble())
    }

    fun agregarseA(parent: Group?) {
        parent.getChildren().add(this)
        parent.getChildren().add(textoSimbolo)
        parent.getChildren().add(textoPais)
    }

    fun agregarNuevoHandler(handler: HandlerDeCarta?) {
        this.onMouseClicked = handler
        textoSimbolo.setOnMouseClicked(handler)
        textoPais.setOnMouseClicked(handler)
    }

    fun limpiarHandler() {
        if (this.onMouseClicked != null) {
            val handler = this.onMouseClicked as HandlerDeCarta
            handler.desarmarHandler()
        }
        desactivarse()
    }

    fun copiarEn(unaCarta: BoxCarta?, otraCarta: Carta?) {
        val handlerDelOtro = unaCarta.getOnMouseClicked() as HandlerDeCarta
        val miHandlerNuevo = handlerDelOtro.copy
        miHandlerNuevo.asociarCarta(otraCarta)
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
        textoSimbolo.setDisable(true)
        textoPais.setDisable(true)
        textoPais.setDisable(true)
    }

    private fun desactivarse() {
        fill = Paint.valueOf(colorActual)
        this.isDisable = false
        textoSimbolo.setDisable(false)
        textoPais.setDisable(false)
        textoPais.setDisable(false)
    }
}