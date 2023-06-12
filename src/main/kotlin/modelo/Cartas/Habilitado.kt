package modelo.Cartas

import modelo.JuegoYJugador.InventarioDeJuego

interface Habilitado {
    fun pedirCarta(mano: ManoDeCartas, mazo: InventarioDeJuego): Habilitado
    fun ocupePais(): Habilitado
}
