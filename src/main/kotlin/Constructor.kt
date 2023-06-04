import modelo.Pais
import serializables.PaisSerializable

class Constructor {

    fun construirPaises(paisesSerializables: ArrayList<PaisSerializable>): HashMap<String, Pais> {
        val paises = HashMap<String, Pais>()
        for(pais in paisesSerializables){
            paises[pais.Pais] = Pais(pais.Pais)
        }
        agregarPaisesLimitrofes(paises, paisesSerializables)
        return paises
    }

    fun agregarPaisesLimitrofes(paises: HashMap<String, Pais>, paisesSeralizables: ArrayList<PaisSerializable>) {
        for(pais in paisesSeralizables){
            val paisesLimitrofes = paises[pais.Pais]?.paisesLimitrofes
            val listaPaisesLimitrofes = pais.LimitaCon.split(",").toTypedArray() //TODO: Pasarlo al parser

            for(nombrePaisLimitrofe in listaPaisesLimitrofes) {
                val paisLimitrofe = paises[nombrePaisLimitrofe]
                if (paisesLimitrofes != null && paisLimitrofe != null) {
                    paisesLimitrofes[nombrePaisLimitrofe] = paisLimitrofe
                }
            }
        }
    }

}