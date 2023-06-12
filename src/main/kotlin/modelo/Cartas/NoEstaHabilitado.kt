package modelo.Cartas

import modelo.JuegoYJugador.InventarioDeJuego

class NoEstaHabilitado : Habilitado {

    override fun pedirCarta(mano: ManoDeCartas, inventario: InventarioDeJuego): Habilitado {
        return this
    }

    override fun ocupePais(): Habilitado {
        return EstaHabilitado()
    }
}

