package modelo.Cartas

import modelo.Excepciones.CanjesError
import modelo.JuegoYJugador.InventarioDeJuego
import java.util.*
import kotlin.collections.ArrayList

class ManoDeCartas {
    private val cartas: ArrayList<Carta> = ArrayList<Carta>()
    private var cantidadDeCanjesHechos: Canjes = CanjesMenosDeTres()
    private var puedePedirCarta: Habilitado = NoEstaHabilitado()
    fun recibirCarta(unaCarta: Carta) {
        cartas.add(unaCarta)
    }

    fun canjearCartas(primeraCarta: Carta, segundaCarta: Carta, terceraCarta: Carta): Int {
        return if (tengoLasCartas(primeraCarta, segundaCarta, terceraCarta)) {
            realizarCanje(primeraCarta, segundaCarta, terceraCarta)
        } else 0
    }

    fun activarCarta(unaCarta: Carta) {
        if (tengo(unaCarta)) {
            unaCarta.activarse()
        }
    }

    private fun tengo(unaCarta: Carta): Boolean {
        return cartas.contains(unaCarta)
    }

    private fun tengoLasCartas(primeraCarta: Carta, segundaCarta: Carta, terceraCarta: Carta): Boolean {
        return tengo(primeraCarta) && tengo(segundaCarta) && tengo(terceraCarta)
    }

    private fun finalizarCanje(primeraCarta: Carta, segundaCarta: Carta, terceraCarta: Carta) {
        primeraCarta.devolverAlMazo()
        segundaCarta.devolverAlMazo()
        terceraCarta.devolverAlMazo()
        cartas.remove(primeraCarta)
        cartas.remove(segundaCarta)
        cartas.remove(terceraCarta)
    }

    private fun realizarCanje(primeraCarta: Carta, segundaCarta: Carta, terceraCarta: Carta): Int {
        var fichasPorCanje = 0
        if (!primeraCarta.esValidoElCanje(segundaCarta, terceraCarta)) {
            throw CanjesError("Las cartas deben tener tres simbolos distintos o iguales, el comodin es igual a todas")
        }
        fichasPorCanje = confirmarCanje()
        finalizarCanje(primeraCarta, segundaCarta, terceraCarta)
        return fichasPorCanje
    }

    private fun confirmarCanje(): Int {
        val fichasPorCanje: Int = cantidadDeCanjesHechos.realizarCanje()
        cantidadDeCanjesHechos = cantidadDeCanjesHechos.obtenerProximoCanje()
        return fichasPorCanje
    }

    fun pedirCarta(inventario: InventarioDeJuego) {
        puedePedirCarta = puedePedirCarta.pedirCarta(this, inventario)
    }

    fun ocupePais() {
        puedePedirCarta = puedePedirCarta.ocupePais()
    }

    fun getCartas(): ArrayList<Carta> {
        return this.cartas
    }

}
