package modelo.JuegoYJugador

import modelo.Batalla.Ejercitos
import modelo.Batalla.Pais
import modelo.Cartas.Carta
import modelo.Cartas.ManoDeCartas
import modelo.Excepciones.NoHayFuerzasRestantesError
import java.util.*

class InventarioDeJugador(dueno: Jugador) {
    private val mano: ManoDeCartas = ManoDeCartas()
    var fichasDisponibles = 0
    val duenoDelCuartel: Jugador = dueno

    fun recibirCarta(unaCarta: Carta) {
        mano.recibirCarta(unaCarta)
    }

    fun canjearCartas(primeraCarta: Carta, segundaCarta: Carta, terceraCarta: Carta) {
        fichasDisponibles += mano.canjearCartas(primeraCarta, segundaCarta, terceraCarta)
    }

    fun generarDivision(cantidadFuerzas: Int): Ejercitos {
        if (cantidadFuerzas > fichasDisponibles) {
            throw NoHayFuerzasRestantesError()
        }
        fichasDisponibles -= cantidadFuerzas
        return Ejercitos(cantidadFuerzas, duenoDelCuartel)
    }

    fun agregarEjercitos(cantidadFichas: Int) {
        fichasDisponibles += cantidadFichas
    }

    fun agregarFichasA(numeroDeFichas: Int, unPais: Pais) {
        if (numeroDeFichas > fichasDisponibles) {
            throw NoHayFuerzasRestantesError()
        }
        fichasDisponibles -= numeroDeFichas
        unPais.agregarEjercito(numeroDeFichas)
    }

    fun activarCarta(unaCarta: Carta) {
        mano.activarCarta(unaCarta)
    }

    fun pedirCarta(inventario: InventarioDeJuego) {
        mano.pedirCarta(inventario)
    }

    fun ocupePais() {
        mano.ocupePais()
    }

    fun getCartas(): ArrayList<Carta> {
        return mano.getCartas()
    }


    fun quedanFichas(): Boolean {
        return fichasDisponibles > 0
    }

}