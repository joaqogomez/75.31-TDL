package modelo.Batalla

interface EstadoEjercitos {
    fun evaluarFuerzasRestantes(): EstadoEjercitos
    fun getCantidadFuerzas() : Int
    fun agregarFuerzas(numeroDeFuerzas: Int): EstadoEjercitos
    fun restarFuerzas(numeroFuerzas: Int): EstadoEjercitos
    fun estanDerrotados(): Boolean
}