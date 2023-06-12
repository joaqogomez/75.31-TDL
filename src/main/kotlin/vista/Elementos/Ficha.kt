package edu.fiuba.algo3.vista.Elementos

import edu.fiuba.algo3.Controlador.handlers.HandlerDePais
import edu.fiuba.algo3.modelo.Batalla.Pais
import javafx.scene.Group
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import javafx.scene.text.Text

class Ficha(color: String?) : Circle() {
    private val texto: Text?
    private var textoNotificable: TextoNotificable? = null

    init {
        fill = Paint.valueOf(color)
        texto = Text("10")
        texto.setFill(Paint.valueOf("#ffffff"))
        texto.setStyle("-fx-font-weight: bold")
        radius = 12.0
    }

    fun setPosicion(posX: Int, posY: Int) {
        this.translateX = posX.toDouble()
        this.translateY = posY.toDouble()
        texto.setTranslateX((posX - 6).toDouble())
        texto.setTranslateY((posY + 4).toDouble())
    }

    fun agregarseA(parent: Group?) {
        parent.getChildren().add(this)
        parent.getChildren().add(texto)
    }

    fun setColor(nuevoColor: String?) {
        fill = Paint.valueOf(nuevoColor)
    }

    fun agregarNuevoHandler(handler: HandlerDePais?) {
        this.onMouseClicked = handler
        texto.setOnMouseClicked(handler)
        this.isDisable = false
        texto.setDisable(false)
    }

    fun notificar(color: String?, fichasDisponibles: Int?) {
        fill = Paint.valueOf(color)
        texto.setText(fichasDisponibles.toString())
        if (textoNotificable != null) {
            textoNotificable.notificar(texto)
        }
    }

    fun getCantidad(): Text? {
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

    fun copiarEn(unaFicha: Ficha?, pais: Pais?) {
        val handlerDelOtro = unaFicha.getOnMouseClicked() as HandlerDePais
        val miHandlerNuevo = handlerDelOtro.copy
        miHandlerNuevo.asociarPais(pais)
        agregarNuevoHandler(miHandlerNuevo)
    }
}