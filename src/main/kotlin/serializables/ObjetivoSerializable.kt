package serializables

import kotlinx.serialization.Serializable

@Serializable
enum class TipoDeObjetivo(tipoDeObjetivo: String) {
    Ocupacion("Ocupacion"), Destruccion("Destruccion"), Comun("Comun")
}

@Serializable
data class ObjetivoSerializable(
    val TipoDeObjetivo: TipoDeObjetivo,
    val ContinentePrincipal: String? = null,
    val ContinenteSecundario: String? = null,
    val CantidadPaises: Int? = null,
    val DestruirJugador: Int? = null,
    val Ocupar: Int? = null
)