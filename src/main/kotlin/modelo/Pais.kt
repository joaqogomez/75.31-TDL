package modelo

import com.sun.tools.javac.util.Pair
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

    fun setCoordenadas(parDeCoordenadas: Pair<Int, Int>) {
        posX = parDeCoordenadas.fst
        posY = parDeCoordenadas.snd
    }

    fun getNombreDelPais(): String {
        return nombre
    }
}