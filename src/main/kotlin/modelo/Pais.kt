package modelo

import modelo.Parser.Coordenadas
import java.util.*

class Pais(
    val nombre: String,
    var paisesConectados: ArrayList<Pais> = ArrayList(),
    var posX: Int = 0,
    var posY: Int = 0
){
    fun agregarPaisConectado(pais: Pais) {
        paisesConectados.add(pais)
    }

    fun setCoordenadas(coordenadas: Coordenadas) {
        this.posX = coordenadas.posX
        this.posY = coordenadas.posY
    }

    fun getNombreDelPais(): String {
        return nombre
    }
}