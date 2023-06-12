package modelo.Cartas

class CanjesMenosDeTres : Canjes {
    private val cantidadFichasMenosDeTres = 4
    private val cantidadFichasPorCanje = 3
    private val cantidadMaximaFichas = 10
    private var fichasPorCanje = 0

    fun CanjesMenosDeTres() {
        fichasPorCanje = cantidadFichasMenosDeTres
    }

    override fun realizarCanje(): Int {
        return fichasPorCanje
    }

    override fun obtenerProximoCanje(): Canjes {
        fichasPorCanje += cantidadFichasPorCanje
        return if (fichasPorCanje >= cantidadMaximaFichas) {
            return CanjesMasDeTres()
        } else this
    }
}
