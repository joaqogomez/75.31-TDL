package Controlador

import edu.fiuba.algo3.Controlador.handlers.HandlerDePais
import edu.fiuba.algo3.modelo.Batalla.Pais
import edu.fiuba.algo3.modelo.JuegoYJugador.Juego
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador
import edu.fiuba.algo3.vista.Elementos.Ficha
import javafx.scene.Scene
import javafx.scene.control.TextField

object Controlador {
    private var teg: Juego? = null
    fun setearJuego(numeroJugadores: Int) {
        teg = Juego(numeroJugadores)
    }

    fun setearNombres(nombres: ArrayList<TextField?>?) {
        for (nombre in nombres) {
            teg.setNombreJugador(nombre)
        }
    }

    private fun setearFichas(fichas: ArrayList<Ficha?>?) {
        teg.setearFichas(fichas)
    }

    fun empezarJuego(fichas: ArrayList<Ficha?>?) {
        teg.iniciarJuego()
        setearFichas(fichas)
    }

    fun pedirMenuSiguiente(): Scene? {
        return teg.prepararMenuSiguiente()
    }

    fun obtenerEscenaObjetivos(): Scene? {
        return teg.mostrarObjetivos()
    }

    fun habilitarPaises(pais: Pais?, confirmacionAtaqueHandle: HandlerDePais?) {
        teg.habilitarPaisesParaAtaque(pais, confirmacionAtaqueHandle)
    }

    fun habilitarPaisesParaColocacion(handler: HandlerDePais?) {
        teg.habilitarPaisesParaColocacion(handler)
    }

    fun reestablecerPaises(jugador: Jugador?, handler: HandlerDePais?) {
        teg.reestablecerPaises(jugador, handler)
    }
}