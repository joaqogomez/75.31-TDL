package modelo.Batalla

import modelo.Excepciones.AtaqueNoPermitidoError
import java.util.*

class Batalla {

    private var perdidaAtacante = 0
    private var perdidaDefensor = 0
    lateinit var resultadoDadoAtacante: ArrayList<Int>
    lateinit var resultadoDadoDefensor: ArrayList<Int>
    private val minimoAtacante = 1

    fun atacar(ejercitoAtacante: Ejercitos, ejercitoDefensor: Ejercitos) {
        tirarDadoAtacante(ejercitoAtacante.getCantidadEjercitos())
        tirarDadoDefensor(ejercitoDefensor.getCantidadEjercitos())
        finalizarAtaque(ejercitoAtacante, ejercitoDefensor)
    }

    private fun finalizarAtaque(ejercitoAtacante: Ejercitos, ejercitoDefensor: Ejercitos) {
        compararResultado(resultadoDadoAtacante, resultadoDadoDefensor)
        ejercitoAtacante.restarEjercitos(perdidaAtacante)
        ejercitoDefensor.restarEjercitos(perdidaDefensor)
    }

    private fun compararResultado(resultadoDadoAtacante: ArrayList<Int>, resultadoDadoDefensor: ArrayList<Int>) {
        val cantidadDeDados = Math.min(resultadoDadoAtacante.size, resultadoDadoDefensor.size) - 1
        for (i in 0 .. cantidadDeDados) {
            if (resultadoDadoAtacante[i] <= resultadoDadoDefensor[i]) {
                perdidaAtacante++
            } else {
                perdidaDefensor++
            }
        }
    }

    private fun tirarDado(cantidadDeTiros: Int): ArrayList<Int> {
        val dadoATirar = Dado()
        return dadoATirar.tirarDado(cantidadDeTiros)
    }

    private fun tirarDadoAtacante(numeroFichasAtacante: Int) {
        if (numeroFichasAtacante == minimoAtacante) throw AtaqueNoPermitidoError("No puedes atacar con una sola ficha")
        resultadoDadoAtacante = tirarDado(numeroFichasAtacante - 1)
    }

    private fun tirarDadoDefensor(numeroFichasDefensor: Int) {
        resultadoDadoDefensor = tirarDado(numeroFichasDefensor)
    }
}