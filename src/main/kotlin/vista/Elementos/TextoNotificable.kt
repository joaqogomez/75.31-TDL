package edu.fiuba.algo3.vista.Elementos

import javafx.scene.Group
import javafx.scene.text.Text

class TextoNotificable : Text {
    var agregadoAGrupo: Group? = null

    constructor(fichaEscuchada: Ficha?) {
        fichaEscuchada.notificame(this)
        text = "Fichas restantes: " + fichaEscuchada.getCantidad().text
        this.setStyle()
    }

    constructor() {
        this.setStyle()
    }

    fun setPosicion(posX: Int, posY: Int) {
        this.translateX = posX.toDouble()
        this.translateY = posY.toDouble()
    }

    private fun setStyle() {
        style = "-fx-font-weight: bold"
    }

    fun notificar(texto: Text?) {
        text = "Fichas restantes: " + texto.getText()
    }

    fun agregarAGrupo(grupo: Group?) {
        agregadoAGrupo = grupo
        grupo.getChildren().add(this)
    }

    fun noEstaAgregadoA(grupoDeEscena: Group?): Boolean {
        return !(grupoDeEscena === agregadoAGrupo)
    }
}