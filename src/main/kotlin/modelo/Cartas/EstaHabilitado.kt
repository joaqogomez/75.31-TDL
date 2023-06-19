package modelo.Cartas

import modelo.JuegoYJugador.InventarioDeJuego

class EstaHabilitado : Habilitado {

    override fun pedirCarta(mano: ManoDeCartas, inventario: InventarioDeJuego): Habilitado {
        inventario.repartirCarta(mano)
        return NoEstaHabilitado()
    }

    override fun ocupePais(): Habilitado {
        return this
    }
}

