package modelo.Parser
import java.util.*

interface ParserTipo {

    fun parsearArchivo(path: String)
    fun getContinentes(): HashMap<String, String>
    fun getFronteras(): HashMap<String, String>
    fun getPaisesConSimbolos(): HashMap<String, String>
    fun getObjetivos(): HashMap<String, ArrayList<String>>
    fun getCoordenadas(): HashMap<String, Coordenadas>
}