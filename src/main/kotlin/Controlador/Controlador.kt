package Controlador

import Controlador.handlers.HandlerDePais
import modelo.Batalla.Pais
import modelo.JuegoYJugador.Juego
import modelo.JuegoYJugador.Jugador
import vista.Elementos.Ficha
import javafx.scene.Scene
import javafx.scene.control.TextField
import vista.Elementos.CampoDeNombre
import java.util.*

object Controlador {
    private var teg: Juego? = null
    fun setearJuego(numeroJugadores: Int) {
        teg = Juego(numeroJugadores)
    }

    fun setearNombres(nombres: ArrayList<TextField>) {
        for (nombre in nombres) {
            val numeroJugador = (nombre as CampoDeNombre?)!!.getNumero()
            teg!!.setNombreJugadorNumero(numeroJugador, nombre.getText())
        }
    }

    private fun setearFichas(fichas: ArrayList<Ficha?>?) {
        val inventario = teg!!.inventario
        val paises = inventario.paises
        /*
        for (i in 0 until inventario.cantidadDePaises()) {
            fichas[i].asociarA(paises[i])
        }

         */
    }

    fun empezarJuego(fichas: ArrayList<Ficha>?) {
        /*
        teg.iniciarJuego()
        setearFichas(fichas)
         */
    }

    fun pedirMenuSiguiente(): Scene? {
       // return teg.prepararMenuSiguiente()
        return null
    }

    fun obtenerEscenaObjetivos(): Scene? {
        //return teg.mostrarObjetivos()
        return null
    }

    fun habilitarPaises(pais: Pais?, confirmacionAtaqueHandle: HandlerDePais?) {
        //teg.habilitarPaisesParaAtaque(pais, confirmacionAtaqueHandle)
    }

    fun habilitarPaisesParaColocacion(handler: HandlerDePais?) {
        //teg.habilitarPaisesParaColocacion(handler)
    }

    fun reestablecerPaises(jugador: Jugador?, handler: HandlerDePais?) {
        //teg.reestablecerPaises(jugador, handler)
    }
}