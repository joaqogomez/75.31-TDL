package serializables

import kotlinx.serialization.Serializable

@Serializable
data class PaisSerializable(
    val Pais: String,
    val PosX: Int,
    val PosY: Int,
    val Continente: String,
    val LimitaCon: String
)