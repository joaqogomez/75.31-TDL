package modelo.Cartas

import modelo.Batalla.Pais
import modelo.Excepciones.CanjesError
import java.util.*

class Carta(val pais: Pais, val simbolo: String) {
    private var mazo: Mazo = Mazo(ArrayList<Carta>())
    private var estadoCarta: EstadoDeActivacion = Desactivada()

    fun esValidoElCanje(segundaCarta: Carta, terceraCarta: Carta): Boolean {
        return if (!hayRepetidas(segundaCarta, terceraCarta)) {
            sonTresIguales(segundaCarta, terceraCarta) || sonTresDistintas(segundaCarta, terceraCarta)
        } else false
    }

    private fun hayRepetidas(segundaCarta: Carta, terceraCarta: Carta): Boolean {
        return this == segundaCarta || this == terceraCarta || segundaCarta == terceraCarta
    }

    private fun sonTresIguales(segundaCarta: Carta, terceraCarta: Carta): Boolean {
        return sonDelMismoTipo(segundaCarta) && sonDelMismoTipo(terceraCarta)
    }

    private fun sonTresDistintas(segundaCarta: Carta, terceraCarta: Carta): Boolean {
        val esDiferenteALaSegunda = noSonDelMismoTipo(segundaCarta)
        val esDiferenteALaTercera = noSonDelMismoTipo(terceraCarta)
        val segundaYTerceraSonDiferentes = segundaCarta.noSonDelMismoTipo(terceraCarta)
        return esDiferenteALaSegunda && esDiferenteALaTercera && segundaYTerceraSonDiferentes
    }

    private fun sonDelMismoTipo(otraCarta: Carta): Boolean {
        return simbolo == otraCarta.simbolo || simbolo == "Comodin" || otraCarta.simbolo == "Comodin"
    }

    private fun noSonDelMismoTipo(otraCarta: Carta): Boolean {
        return !sonDelMismoTipo(otraCarta)
    }

    fun activarse() {
        if (estadoCarta.estaActivada()) {
            throw CanjesError("La carta esta Activada")
        }
        estadoCarta = estadoCarta.activarseEn(pais)
    }

    fun devolverAlMazo() {
        estadoCarta = Desactivada()
        mazo.vuelveAlMazo(this)
    }

    fun asociarAlMazo(unMazo: Mazo) {
        mazo = unMazo
    }


    override fun equals(otro: Any?): Boolean {
        if (this === otro) return true else if (otro == null || otro::class != Carta::class) return false
        val otraCarta = otro as Carta
        return pais.equals(otraCarta.pais) && simbolo == otraCarta.simbolo
    }
}