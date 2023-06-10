package modelo.Parser

import modelo.Carta
import modelo.Continente
import modelo.Jugador
import modelo.Objetivo.Objetivo
import modelo.Batalla.Pais
import java.util.*

class Parser {
    lateinit var parser: ParserTipo
    var objetos: Constructor

    constructor(jugadores: HashMap<Int, Jugador>) {
        objetos = Constructor(jugadores)
    }

    constructor() {
        objetos = Constructor()
    }

    fun parsearArchivo(path: String) {
        if (!::parser.isInitialized) {
            if (path.contains("json")) parser = ParserJson()
        }
        if (::parser.isInitialized){
            parser!!.parsearArchivo(path)
        }
    }

    fun construirObjetos() {
        objetos.construirPaisesYCartas(
            parser!!.getPaisesConSimbolos(),
            parser!!.getFronteras(),
            parser!!.getCoordenadas()
        )
        objetos.construirContinente(parser.getContinentes())
        objetos.contruirObjetivos(parser.getObjetivos())
    }

    fun getPaises(): HashMap<String, Pais> {
        return objetos.getPaises()
    }

    fun getCartas(): ArrayList<Carta> {
        return objetos.getCartas()
    }

    fun getContinentes(): HashMap<String, Continente> {
        return objetos.getContinente()
    }
    fun getObjetivos(): ArrayList<Objetivo> {
        return objetos.getObjetivos()
    }
}