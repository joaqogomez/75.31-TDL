package modelo.Batalla

import modelo.Excepciones.AtaqueNoPermitidoError
import modelo.Excepciones.MovimientoDeEjercitoError
import modelo.Parser.Coordenadas
import java.util.*
import kotlin.collections.ArrayList

class Pais(nombre: String) {
    private var ejercitos: Ejercitos
    private val nombreDelPais: String
    private val paisesConectados: ArrayList<Pais>
    private var posX = 0
    private var posY = 0

    init {
        ejercitos = EjercitosNulos()
        nombreDelPais = nombre
        paisesConectados = ArrayList()
    }

    fun recibirTropas(otrosEjercitos: Ejercitos) {
        ejercitos = ejercitos.disputarDominioDe(this, otrosEjercitos)
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
    }

    fun atacarA(otroPais: Pais) {
        verificarPosibilidadDeAtaque(otroPais)
        val batalla = Batalla()
        batalla.atacar(ejercitos, otroPais.ejercitos)
        otroPais.recibirTropas(ejercitos)
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
    }

    fun setCoordenadas(parDeCoordenadas: Coordenadas) {
        posX = parDeCoordenadas.posX
        posY = parDeCoordenadas.posY
    }

    private fun verificarPosibilidadDeAtaque(otroPais: Pais) {
        if (esDelMismoEquipo(otroPais)) {
            throw AtaqueNoPermitidoError("No se puede atacar a un pais del mismo equipo")
        }
        if (!esLimitrofe(otroPais)) {
            throw AtaqueNoPermitidoError("No se puede atacar a un pais no limitrofe")
        }
    }

}