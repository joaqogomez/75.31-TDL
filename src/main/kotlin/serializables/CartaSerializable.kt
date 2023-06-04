package serializables

import kotlinx.serialization.Serializable

@Serializable
enum class Simbolo(tipo: String) {
    Globo("Globo"), Barco("Barco"), Cañon("Cañon"), Comodin("Comodin")
}

@Serializable
data class CartaSerializable(
    val Pais: String,
    val Simbolo: Simbolo
)