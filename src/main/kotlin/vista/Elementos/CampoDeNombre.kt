package vista.Elementos

import javafx.scene.control.TextField

class CampoDeNombre(private val numeroJugador: Int) : TextField() {
    init {
        setNombreDeCampo(numeroJugador)
        setPosicion(numeroJugador)
        setPropiedades(numeroJugador)
    }

    private fun setNombreDeCampo(numeroDeJugador: Int) {
        text = "Jugador " + numeroDeJugador.toString()
    }

    private fun setPosicion(numeroDeJugador: Int) {
        this.translateX = 900.0
        this.translateY = (100 + (numeroDeJugador - 1) * 40).toDouble()
    }

    private fun setPropiedades(numeroJugador: Int) {
        height = 20.0
        val colorDeJugador = colores.getColor(numeroJugador)
        style = "-fx-font-weight: bold; -fx-background-color: " +
                colorDeJugador + "; -fx-border-color: #000000;" + "-fx-text-fill: #ffffff"
    }

    fun getNumero(): Int {
        return numeroJugador
    }

    companion object {
        private val colores: ColoresJugadores = ColoresJugadores()
    }
}