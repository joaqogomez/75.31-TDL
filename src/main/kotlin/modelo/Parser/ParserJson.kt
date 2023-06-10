package modelo.Parser

import com.sun.tools.javac.util.Pair
import jdk.nashorn.internal.parser.JSONParser
import org.json.JSONArray
import org.json.JSONObject
import java.io.FileReader
import java.io.IOException
import java.text.ParseException
import java.util.*

class ParserJson : ParserTipo {

    private var paises: HashMap<String, String> = HashMap()
    private var continentes: HashMap<String, String> = HashMap()
    private var fronteras: HashMap<String, String> = HashMap()
    private var coordenadas: HashMap<String, Pair<Int, Int>> = HashMap()
    private var objetivos: HashMap<String, ArrayList<String>> = HashMap()

    override fun parsearArchivo(path: String) {
        val jsonParser = JSONParser()
        try {
            FileReader(path).use { reader ->
                val obj: Any = jsonParser.parse(reader)
                val tegList: JSONArray = obj as JSONArray
                if (path == "Cartas.json") tegList.forEach { carta -> parseCartasObject(carta as JSONObject) }
                if (path == "Fronteras.json") tegList.forEach { frontera -> parseFronterasObject(frontera as JSONObject) }
                if (path == "Objetivos.json") tegList.forEach { objetivo -> parseObjetivosObject(objetivo as JSONObject) }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    private fun parseObjetivosObject(objetivo: JSONObject) {
        val cartasObject: JSONObject = objetivo as JSONObject
        val tipo = cartasObject.get("TipoDeObjetivo") as String
        if (!objetivos.containsKey(tipo)) {
            objetivos.put(tipo, ArrayList())
        }
        if (tipo == "Ocupacion") {
            val principal = cartasObject.get("ContinentePrincipal") as String
            val secundario = cartasObject.get("ContinenteSecundario") as String
            val cantidad = cartasObject.get("CantidadPaises") as String
            val completo = "$principal,$secundario,$cantidad"
            objetivos[tipo]!!.add(completo)
        }
        if (tipo == "Destruccion") {
            val jugador = cartasObject.get("DestruirJugador") as String
            objetivos[tipo]!!.add(jugador)
        }
        if (tipo == "Comun") {
            val cantidad = cartasObject.get("Ocupar") as String
            objetivos[tipo]!!.add(cantidad)
        }
    }

    private fun parseCartasObject(cartas: JSONObject) {
        val cartasObject: JSONObject = cartas as JSONObject
        val nombrePais = cartasObject.get("Pais") as String
        val simbolo = cartasObject.get("Simbolo") as String
        paises.put(nombrePais, simbolo)
    }

    private fun parseFronterasObject(fronteras: JSONObject) {
        val fronterasObject: JSONObject = fronteras as JSONObject
        val nombrePais = fronterasObject.get("Pais") as String
        val cordX: Int = fronterasObject.get("PosX") as String?.toInt()
        val cordY: Int = fronterasObject.get("PosY") as String?.toInt()
        val nombreContinente = fronterasObject.get("Continente") as String
        val paisesLimitrofes = fronterasObject.get("Limita con") as String
        this.fronteras.put(nombrePais, paisesLimitrofes)
        coordenadas.put(nombrePais, Pair(cordX, cordY))
        if (!continentes.containsKey(nombreContinente)) {
            continentes.put(nombreContinente, nombrePais)
        } else {
            val paisesContinente =
                continentes[nombreContinente].toString() + "," + nombrePais //"Argentina,Chile,Brazil"
            continentes.put(nombreContinente, paisesContinente)
        }
    }

    override fun getPaisesConSimbolos(): HashMap<String, String> {
        return paises
    }

    override fun getFronteras(): HashMap<String, String> {
        return fronteras
    }

    override fun getContinentes(): HashMap<String, String> {
        return continentes
    }

    override fun getObjetivos(): HashMap<String, ArrayList<String>> {
        return objetivos
    }

    override fun getCoordenadas(): HashMap<String, Pair<Int, Int>> {
        return coordenadas
    }

    init {
        continentes = HashMap()
        fronteras = HashMap()
        objetivos = HashMap()
        coordenadas = HashMap<String, Pair<Int, Int>>()
    }
}