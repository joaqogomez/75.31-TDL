package modelo.Cartas

class CanjesMasDeTres : Canjes {
    private val cantidadFichasPorCanje = 5
    private var fichasPorCanje = 10

    override fun realizarCanje(): Int {
        return fichasPorCanje
    }

    override fun obtenerProximoCanje(): Canjes {
        fichasPorCanje += cantidadFichasPorCanje
        return this
    }
}
