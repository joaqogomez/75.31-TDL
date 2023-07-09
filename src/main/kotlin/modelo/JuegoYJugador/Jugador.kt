package modelo.JuegoYJugador

import modelo.Batalla.Batalla
import modelo.Batalla.Ejercitos
import modelo.Batalla.Pais
import modelo.Cartas.Carta
import modelo.Excepciones.CanjesError
import modelo.Excepciones.ColocacionEjercitoError
import modelo.Objetivo.Objetivo
import modelo.Ubicable
import java.util.*

class Jugador(numeroDeJugador: Int) : Ubicable() {
    private val numeroJugador: Int = numeroDeJugador
    lateinit var nombreJugador: String
    val paisesOcupados: ArrayList<Pais> = ArrayList<Pais>()
    val inventarioDeJugador: InventarioDeJugador = InventarioDeJugador(this)
    lateinit var objetivo: Objetivo


    fun ocupa(unPais: Pais) {
        ocuparCon(unPais, 1)
    }

    fun ocuparCon(unPais: Pais, cantidadFuerzas: Int) {
        val nuevaDivision: Ejercitos = inventarioDeJugador.generarDivision(cantidadFuerzas)
        unPais.recibirTropas(nuevaDivision)
        devolverFuerzas(unPais, cantidadFuerzas)
    }

    private fun devolverFuerzas(unPais: Pais, cantidadFuerzas: Int) {
        if (!ocupeElPais(unPais)) {
            agregarFichas(cantidadFuerzas)
        }
    }

    fun perdisteA(unPais: Pais) {
        paisesOcupados.remove(unPais)
    }

    fun ocupasteA(unPais: Pais) {
        paisesOcupados.add(unPais)
    }

    fun agregarFichas(cantidadFichas: Int) {
        inventarioDeJugador.agregarEjercitos(cantidadFichas)
        notificar()
    }

    fun atacarPaisDesdeA(unPais: Pais, otroPais: Pais): Batalla {
        val b = unPais.atacarA(otroPais)
        verificarOcupacion(otroPais)
        return b
    }

    private fun verificarOcupacion(otroPais: Pais) {
        if (ocupeElPais(otroPais)) {
            inventarioDeJugador.ocupePais()
        }
    }

    private fun ocupeElPais(otroPais: Pais): Boolean {
        return paisesOcupados.contains(otroPais)
    }

    fun cantidadDeEjercitosAColocar(inventarioDeJuego: InventarioDeJuego) {
        var cantidadEjercitos = paisesOcupados.size / 2
        cantidadEjercitos += inventarioDeJuego.ejercitosPorContinentesConquistados(paisesOcupados)
        agregarFichas(cantidadEjercitos)
    }

    fun agregarFichasA(numeroDeFichas: Int, unPais: Pais) {
        if (ocupeElPais(unPais)){
            inventarioDeJugador.agregarFichasA(numeroDeFichas, unPais)
            notificar()
        } else throw ColocacionEjercitoError("Debes elegir a un pais tuyo")
    }

    fun recibirCarta(unaCarta: Carta?) {
        inventarioDeJugador.recibirCarta(unaCarta!!)
    }

    fun canjearCartas(primeraCarta: Carta, segundaCarta: Carta, terceraCarta: Carta) {
        inventarioDeJugador.canjearCartas(primeraCarta, segundaCarta, terceraCarta)
    }

    fun canjearCarta(unaCarta: Carta) {
        if (puedoCanjearLaCarta(unaCarta)) {
            inventarioDeJugador.activarCarta(unaCarta)
        } else throw CanjesError("Debes tener a este pais para activarla")
    }

    private fun puedoCanjearLaCarta(unaCarta: Carta): Boolean {
        return paisesOcupados.contains(unaCarta.getPais())
    }

    fun fueDerrotado(): Boolean {
        return paisesOcupados.isEmpty()
    }

    fun moverFichasDeACon(unPais: Pais, otroPais: Pais, cantidad: Int) {
        unPais.moverEjercitoA(otroPais, cantidad)
    }

    fun pedirCarta(inventario: InventarioDeJuego) {
        inventarioDeJugador.pedirCarta(inventario)
    }

    fun setNombre(nombre: String) {
        nombreJugador = nombre
    }

    fun esElNumero(numero: Int): Boolean {
        return numeroJugador == numero
    }

    fun asignarObjetivo(objetivo: Objetivo) {
        this.objetivo = objetivo
    }

    public fun gane(): Boolean {
        return objetivo.objetivoCumplido(paisesOcupados)
    }

    fun getCartas(): ArrayList<Carta> {
        return inventarioDeJugador.getCartas()
    }

    fun quedanFichas(): Boolean {
        return inventarioDeJugador.quedanFichas()
    }

    fun getNumeroJugador(): Int {
        return numeroJugador
    }

    override fun ejercitos(): Int {
        return inventarioDeJugador.fichasDisponibles
    }

    override fun nroJugador(): Int {
        return numeroJugador
    }

    override fun posX(): Int {
        return 15
    }

    override fun posY(): Int {
        return 15
    }

}

