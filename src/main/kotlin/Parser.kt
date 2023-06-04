import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import serializables.CartaSerializable
import serializables.ObjetivoSerializable
import serializables.PaisSerializable

class Parser{

    fun getPaises(): ArrayList<PaisSerializable> {
        val paisesString = this::class.java.classLoader.getResource("Paises.json").readText()
        return Json.decodeFromString(paisesString)
    }

    fun getObjetivos(): ArrayList<ObjetivoSerializable>{
        val cartasString = this::class.java.classLoader.getResource("Objetivos.json").readText()
        return Json.decodeFromString(cartasString)
    }

    fun getCartas(): ArrayList<CartaSerializable>{
        val cartasString = this::class.java.classLoader.getResource("Cartas.json").readText()
        return Json.decodeFromString(cartasString)
    }
}