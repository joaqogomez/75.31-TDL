package Controlador
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class EstadoJuego(val estado: ArrayList<JugadorData>)

@Serializable
data class JugadorData(val nombre: String, var paises: ArrayList<PaisData>)

@Serializable
data class PaisData(val nombre: String, val ejercitos: Int)
