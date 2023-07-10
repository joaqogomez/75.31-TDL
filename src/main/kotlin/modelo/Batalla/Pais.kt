package modelo.Batalla

import modelo.Excepciones.AtaqueNoPermitidoError
import modelo.Excepciones.MovimientoDeEjercitoError
import modelo.Parser.Coordenadas
import modelo.Ubicable
import java.util.*

class Pais(nombre: String) : Ubicable() {
    var ejercitos: Ejercitos
    private val nombreDelPais: String
    private val paisesConectados: ArrayList<Pais>
    var posX = 0
    var posY = 0

    init {
        ejercitos = EjercitosNulos()
        nombreDelPais = nombre
        paisesConectados = ArrayList()
    }

    fun recibirTropas(otrosEjercitos: Ejercitos) {
        ejercitos = ejercitos.disputarDominioDe(this, otrosEjercitos)
        notificar()
    }

    fun getNombreDelPais(): String {
        return nombreDelPais
    }

    fun getCantidadDeEjercitos(): Int {
        return ejercitos.getCantidadEjercitos()
    }

    fun agregarPaisConectado(unPais: Pais) {
        paisesConectados.add(unPais)
    }

    fun agregarEjercito(cantidadDeEjercitos: Int) {
        ejercitos.agregarEjercitos(cantidadDeEjercitos)
        notificar()
    }

    fun atacarA(otroPais: Pais): Batalla {
        verificarPosibilidadDeAtaque(otroPais)
        val batalla = Batalla()
        batalla.atacar(ejercitos, otroPais.ejercitos)
        otroPais.recibirTropas(ejercitos)
        notificar()
        otroPais.notificar()
        return batalla
    }

    private fun esDelMismoEquipo(otroPais: Pais): Boolean {
        return ejercitos.sonAliadosDe(otroPais.ejercitos)
    }

    private fun esLimitrofe(otroPais: Pais): Boolean {
        return paisesConectados.contains(otroPais)
    }

    fun moverEjercitoA(otroPais: Pais, cantidad: Int) {
        if (!esDelMismoEquipo(otroPais) || !esLimitrofe(otroPais)) {
            throw MovimientoDeEjercitoError("Debes mover el ejercito de tu equipo a otro tuyo y debe ser limitrofe")
        }
        ejercitos.moverEjercitoACon(otroPais.ejercitos, cantidad)
        notificar()
        otroPais.notificar()
    }

    fun setCoordenadas(parDeCoordenadas: Coordenadas) {
        posX = parDeCoordenadas.component1()
        posY = parDeCoordenadas.component2()
    }

    private fun verificarPosibilidadDeAtaque(otroPais: Pais) {
        if (esDelMismoEquipo(otroPais)) {
            throw AtaqueNoPermitidoError("No se puede atacar a un pais del mismo equipo")
        }
        if (!esLimitrofe(otroPais)) {
            throw AtaqueNoPermitidoError("No se puede atacar a un pais no limitrofe")
        }
    }

    override fun ejercitos(): Int {
        return ejercitos.getCantidadEjercitos()
    }

    override fun nroJugador(): Int {
        return ejercitos.comandante.getNumeroJugador()
    }

    override fun posX(): Int {
        return posX
    }

    override fun posY(): Int {
        return posY
    }

}